package com.example.ProductService.Service;

import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ProductService.Dao.ProductRepository;
import com.example.ProductService.Model.Product;

@Service
public class PoductSer {
	
	@Autowired
	private ProductRepository pr;
	
	public ResponseEntity<Product> addProduct(Product prod){
		
		 try {
		 return new ResponseEntity<>(pr.save(prod), HttpStatus.CREATED);
   
		 } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

		
	}
	
//	public ResponseEntity<Product> updateProduct(Product a,String id){
//	Optional<Product> product = pr.findById(id);
//	if (!product.isEmpty()) {
//		Product pp=product.get();
//		pp.setProductId(a.getProductId());
//		pp.setProductName(a.getProductName());
//		pp.setProductDescription(a.getProductDescription());
//		pp.setProductPrice(a.getProductPrice());
//		
//		return new ResponseEntity<Product>(pr.save(pp),HttpStatus.OK);
//	} else {
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
//
//	}
	
	public ResponseEntity<Product> deleteProduct(Product a,int id)
	{
		Optional<Product> product = pr.findById(id);
		if (!product.isEmpty()) {
			pr.deleteById(id);
			return new ResponseEntity<Product>(HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	public ResponseEntity<?> searchProduct(int id) throws AttributeNotFoundException
	{
		Optional<Product> pp = pr.findById(id);
		if(pp.isPresent())
		{
			return new ResponseEntity<Product>(pp.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}


