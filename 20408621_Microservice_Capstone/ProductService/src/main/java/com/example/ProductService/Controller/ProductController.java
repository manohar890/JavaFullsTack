package com.example.ProductService.Controller;

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
import com.example.ProductService.Dao.ProductRepository;
import com.example.ProductService.Model.Product;
import com.example.ProductService.Service.PoductSer;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	PoductSer ps;
	@Autowired
	ProductRepository pr;
	
	@PostMapping("/addproduct")
	public ResponseEntity<Product> addAccount(@RequestBody Product prod){
		System.out.println(prod.toString());
		return ps.addProduct(prod);
	}
	
	
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product p,@PathVariable("id") int id) throws AttributeNotFoundException
	{
		Optional<Product> product =pr.findById(id);

		if (!product.isEmpty()) {
			
			return new ResponseEntity<Product>(pr.save(p),HttpStatus.OK);
		}
		else
		{
			
			return new ResponseEntity<>(id+ "Id not Found",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@RequestBody Product p,@PathVariable("id") int id) throws AttributeNotFoundException{
		Optional<Product> product =pr.findById(id);
		if(!product.isEmpty())
		{
			pr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<>(id+ "Id does not exist",HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/searchProduct/{id}")
	public ResponseEntity<?> searchProduct(@PathVariable("id") int id) throws AttributeNotFoundException{
		Optional<Product> product =pr.findById(id);
		if(!product.isEmpty())
		{
			
			return ps.searchProduct(id);
			
		}
		else
		{
			return ps.searchProduct(id);
		}
}
	
}



