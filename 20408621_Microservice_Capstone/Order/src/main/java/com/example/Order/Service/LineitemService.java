package com.example.Order.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Order.Model.Lineitem;
import com.example.Order.Repository.LineItemRepository;

@Service
public class LineitemService {
	
	
	@Autowired
	LineItemRepository lr;
	

	public ResponseEntity<?> addLineItem(Lineitem li)
	{
		try
		{
			return new ResponseEntity<>(lr.save(li),HttpStatus.CREATED);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	
	public ResponseEntity<?> deleteLineItem(int lid)
	{
		Optional<Lineitem> li= lr.findById(lid);
		if(!li.isEmpty())
		{
			lr.deleteById(lid);
			return new ResponseEntity<>(lid +" customer deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
		
	}
	public ResponseEntity<?> updateLineItem(Lineitem li,int lid)
	{
		Optional<Lineitem> l =lr.findById(lid);
		if(!l.isEmpty()) {
			return new ResponseEntity<>(lr.save(li),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<?> searchLineItem(int lid){
		Optional<Lineitem> li=lr.findById(lid);
		if(!li.isEmpty())
		{
			return new ResponseEntity<>(li.get(),HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
		
	}
	
	

}
