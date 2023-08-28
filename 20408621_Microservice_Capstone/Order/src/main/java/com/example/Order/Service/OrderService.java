package com.example.Order.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Order.Model.Orders;
import com.example.Order.Repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository or;
	
	public Orders addOrder(Orders o)
	{
		try
		{
			return or.save(o);
		}
		catch (Exception e)
		{
			return new Orders();
			}
}
	
	public ResponseEntity<?> deleteOrder(int id)
	{
		Optional<Orders> o= or.findById(id);
		if(!o.isEmpty())
		{
			or.deleteById(id);
			return new ResponseEntity<>(id +" customer deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
		
	}
	public ResponseEntity<?> updateOrder(Orders od,int id)
	{
		Optional<Orders> o =or.findById(id);
		if(!o.isEmpty()) {
			return new ResponseEntity<>(or.save(od),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<?> searchOrder(int id){
		Optional<Orders> o=or.findById(id);
		if(!o.isEmpty())
		{
			return new ResponseEntity<>(o.get(),HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
		
	}
public List<Orders> findOrders(List<Integer> lis){
		if(or.findAllById(lis).isEmpty()) {
			return Stream.of(new Orders()).toList();
		}
		return or.findAllById(lis);
		
	}
	


}


