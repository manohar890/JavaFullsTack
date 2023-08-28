package com.example.Inventory.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Inventory.Dao.InventoryRepository;
import com.example.Inventory.Model.Inventory;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository ir;
	
	public ResponseEntity<?> addinventory(Inventory in)
	{
		try
		{
			return new ResponseEntity<>(ir.save(in),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("an error occur",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> deleteinventory(int id)
	{
	Optional<Inventory> in= ir.findById(id);
		if(!in.isEmpty())
		{
			ir.deleteById(id);
			return new ResponseEntity<>(id +" deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
		
	}
	
	public ResponseEntity<?> updateInventory(Inventory in,int id)
	{
		Optional<Inventory> i =ir.findById(id);
		if(!i.isEmpty()) {
			return new ResponseEntity<>(ir.save(in),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<?> searchInventory(int id){
		Optional<Inventory> in=ir.findById(id);
		if(!in.isEmpty())
		{
			return new ResponseEntity<>(in.get(),HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	


}
