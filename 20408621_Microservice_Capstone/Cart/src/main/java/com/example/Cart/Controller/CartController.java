package com.example.Cart.Controller;

import java.util.List;

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

import com.example.Cart.Model.*;
import com.example.Cart.Repository.CartRespository;
import com.example.Cart.Service.CartService;

@RestController
@RequestMapping("/Cart")
public class CartController {
	
	@Autowired
	CartService cs;
	
	@Autowired
	CartRespository crs;
	
	@PostMapping("/addCart")
	public ResponseEntity<?> addCart(@RequestBody Cart c)
	{
		System.out.println(c.toString());
		return cs.addCart(c);
	}

	@DeleteMapping("/emptyCart/{id}")
	public ResponseEntity<?> emptyCart(@PathVariable("id") int id)
	{
		return cs.emptyCart(id);
		
	}

	@PutMapping("/updateCarts/{id}")
	public ResponseEntity<?> updateCarts(@RequestBody  Cart c,@PathVariable("id") int id) throws AttributeNotFoundException{
		return new ResponseEntity<>(crs.save(c),HttpStatus.OK);
	}
	
	@PutMapping("/updateCart/{id}")
	public ResponseEntity<?> updateCart(@RequestBody  Cart c,@PathVariable("id") int id) throws AttributeNotFoundException{
		return cs.updateCart(c, id);
	}
	
	@GetMapping("/searchCart/{id}")
	public List<Lineitem> searchCart(@PathVariable("id") 	int id) throws AttributeNotFoundException{
		return cs.searchCart(id).getListitem();
	}
		

}
