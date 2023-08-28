package com.example.Cart.Service;

import java.util.Optional;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Cart.Model.Cart;
import com.example.Cart.Model.Lineitem;
import com.example.Cart.Repository.CartRespository;

@Service
public class CartService {
	
	@Autowired
	CartRespository cr;
	
	@Autowired
	LineitemService ls;
	
	public ResponseEntity<?> addCart(Cart c)
	{
		try
		{
			return new ResponseEntity<>(cr.save(c),HttpStatus.CREATED);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	
	public ResponseEntity<?> emptyCart(int id)
	{
		Optional<Cart> c= cr.findById(id);
		if(!c.isEmpty())
		{
			cr.deleteById(id);
			return new ResponseEntity<>(id +" customer deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
		
	}
	public ResponseEntity<?> updateCart(Cart ca,int id)
	{
		Optional<Cart> c =cr.findById(id);
		if(!c.isEmpty()) {
			Cart r=c.get();
			List<Lineitem> l=r.getListitem();
			for(Lineitem li:l) {
				ls.deleteLineItem(li.getItemId());
			}
			ca.setListitem(null);
			return new ResponseEntity<>(cr.save(ca),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
		}
	}
	
	public Cart searchCart(int id){
		Optional<Cart> c=cr.findById(id);
		if(!c.isEmpty())
		{
			return c.get();
			
		}
		else
		{
			return new Cart();
		}
		
	}
	
	

}
