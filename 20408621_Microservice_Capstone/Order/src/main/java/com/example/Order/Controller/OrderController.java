package com.example.Order.Controller;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

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

import com.example.Order.Model.Orders;
import com.example.Order.Repository.OrderRepository;
import com.example.Order.Service.OrderService;
@RestController
@RequestMapping("/Order")
public class OrderController {
	@Autowired
	OrderService os;

	@Autowired
	OrderRepository or;
	int id =0;
	
	@PostMapping("/addOrder")
	public Orders addCustomer(@RequestBody Orders o)
	{
		o.setOrderId(++id);
		or.save(o);
		return o;
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable("id") int id)
	{
		return os.deleteOrder(id);
		
	}
	
	@PutMapping("/updateOrder/{id}")
	public ResponseEntity<?> updateOrder(@RequestBody  Orders o,@PathVariable("id") int id) throws AttributeNotFoundException{
		Optional<Orders> ors=or.findById(id);
		if(ors.isPresent()) {
			return new ResponseEntity<>(o,HttpStatus.OK);
		}
		return new ResponseEntity<>("Cart Id Not Found",HttpStatus.NOT_FOUND);
			
		
		
	}
	@PutMapping("/updateOrders/{id}")
	public ResponseEntity<?> updatesOrder(@RequestBody  Orders o,@PathVariable("id") int id) throws AttributeNotFoundException{
		return os.updateOrder(o, id);
	}
	
	@GetMapping("/searchOrder{id}")
	public ResponseEntity<?> searchOrder(@PathVariable("id") int id) throws AttributeNotFoundException{
		return os.searchOrder(id);
	}
		

	@GetMapping("/getOrdersforCustomer/{lis}")
	public List<Orders> findOrders(@PathVariable List<Integer> lis){
		
		return os.findOrders(lis);
		
	}
	

}
