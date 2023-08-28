package com.example.Customer.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Customer.Dao.BillingAddressRepository;
import com.example.Customer.Model.BillingAddress;

@Service
public class AddressService {
	
	@Autowired
	BillingAddressRepository ar;
	
	public ResponseEntity<?> addCustomerAddress(BillingAddress add)
	{
		try
		{
			return new ResponseEntity<>(ar.save(add),HttpStatus.CREATED);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> deleteCustomerAddress(int id)
	{
		Optional<BillingAddress> add= ar.findById(id);
		if(!add.isEmpty())
		{
			ar.deleteById(id);
			return new ResponseEntity<>(id +"deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
		
	}
	public ResponseEntity<?> updateCustomerAddress(BillingAddress a,int id)
	{
		Optional<BillingAddress> add=ar.findById(id);
		if(!add.isEmpty()) {
			return new ResponseEntity<>(ar.save(a),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<?> searchCustomerAddress(int id){
		Optional<BillingAddress> add=ar.findById(id);
		if(!add.isEmpty())
		{
			return new ResponseEntity<>(add.get(),HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
		
	}
	

}
