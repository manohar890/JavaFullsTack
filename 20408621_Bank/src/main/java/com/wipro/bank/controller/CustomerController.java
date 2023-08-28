package com.wipro.bank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.bank.Model.Customer;
import com.wipro.bank.exception.InternalServerException;
import com.wipro.bank.repository.CustomerRepository;
import com.wipro.bank.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired 
	private CustomerRepository rep;
	
	@Autowired
	private CustomerService ser;;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		try {
		return new ResponseEntity<>(ser.save(customer),HttpStatus.CREATED);
		}catch(Exception e) {
			throw new InternalServerException();
		}
	}
	
	@GetMapping("/getCustomers")
	public ResponseEntity<?> getCustomers(){
		Map <String,String> msg=new HashMap<String,String>();
		try {
			List<Customer> data=rep.findAll();
			if(data.size()==0) {
			msg.put("Status  ", "204");
			msg.put("Message ", "No Content");
			return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
			}
			else {
				return new ResponseEntity<List<Customer>>(data,HttpStatus.OK);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			throw new InternalServerException();
		}
		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id){
		Map <String,String> msg=new HashMap<String,String>();
		try {
		Optional<Customer> customer = rep.findById(id);
		if(customer.isPresent()) {
			return new ResponseEntity<>(customer.get(),HttpStatus.OK);
			
		}else {
			msg.put("Id ", ""+id);
			msg.put("Message  ","Id Not Found");
			return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			throw new InternalServerException();
		}
	}

	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer cus){
		Map <String,String> msg=new HashMap<String,String>();
		try {
		Optional<Customer> cust=rep.findById(id);
		if(cust.isPresent()) {
			return new ResponseEntity<>(rep.save(cus),HttpStatus.OK);
		}else {
			msg.put("Id  ", ""+id);
			msg.put("Message  ","Id Not Found");
			return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		}
		
	 }catch (Exception e) {
		// TODO: handle exception
		 throw new InternalServerException();
	}
	}	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<?> deleteAll(){
		
		try {
			rep.deleteAll();
			return new ResponseEntity<>("All Customer Details deleted Successfully.....",HttpStatus.ACCEPTED);
			
		}catch (Exception e) {
			// TODO: handle exception
			throw new InternalServerException();
		}
	}
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		Map <String,String> msg=new HashMap<String,String>();
		try {
		Optional<Customer> customer = rep.findById(id);
		if(customer.isPresent()) {
			rep.deleteById(id);
			msg.put("Id", ""+id);
			msg.put("message","Deleted Successfully...");
			return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
			
		}else {
			msg.put("Id ", ""+id);
			msg.put("Message "," Id Not Found");
			return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			throw new InternalServerException();
		}
	}
	@PutMapping("/transfer/{sorc}/{dest}/{amt}")
	public ResponseEntity<?> fundTransfer(@PathVariable("sorc") Long sorc,@PathVariable("dest") 
	Long dest,@PathVariable("amt") double amt){
		try {
			return ser.fundTransfer(sorc, dest, amt);
		}catch (InternalServerException e) {
			// TODO: handle exception
			throw new InternalServerException();
		}
	}
}
