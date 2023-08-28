package com.example.Customer.Controller;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Customer.Model.BillingAddress;
import com.example.Customer.Service.AddressService;

@RestController
@RequestMapping("/Address")
public class AddressController {
	
	
	
	@Autowired
	AddressService as;
	
	@PostMapping("/addAddress")
	public ResponseEntity<?> addCustomerAddress(@RequestBody BillingAddress add)
	{
		return as.addCustomerAddress(add);
	}
	
	
	@DeleteMapping("/deleteAddress/{id}")
	public ResponseEntity<?> deleteCustomerAddress(@PathVariable("id") int id)
	{
		return as.deleteCustomerAddress(id);
		
	}
	
	@PutMapping("/updateAddress/{id}")
	public ResponseEntity<?> updateCustomerAddress(@RequestBody  BillingAddress add,@PathVariable("id") int id) throws AttributeNotFoundException{
		return as.updateCustomerAddress(add, id);
	}
	

	@GetMapping("/searchAddress/{id}")
	public ResponseEntity<?> searchCustomerAddress(@PathVariable("id") int id) throws AttributeNotFoundException{
		return as.searchCustomerAddress(id);
	}
	

}
