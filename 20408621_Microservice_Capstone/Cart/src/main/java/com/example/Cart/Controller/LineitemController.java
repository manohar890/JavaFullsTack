package com.example.Cart.Controller;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Cart.Model.Lineitem;
import com.example.Cart.Service.LineitemService;

@RestController
public class LineitemController {
	
	@Autowired
	LineitemService ls;
	
	@PostMapping("/addLineItem")
	public ResponseEntity<?> addLineItem(@RequestBody Lineitem li)
	{
		return ls.addLineItem(li);
	}
	
	@DeleteMapping("/deleteLineItem/{id}")
	public ResponseEntity<?> deleteLineItem(@PathVariable("id") int id)
	{
		return ls.deleteLineItem(id);
		
	}
	
	@PutMapping("/updateLineItem/{id}")
	public ResponseEntity<?> updateLineItem(@RequestBody  Lineitem li,@PathVariable("id") int id) throws AttributeNotFoundException{
		return ls.updateLineItem(null, id);
	}
	
	@GetMapping("/searchLineItem/{id}")
	public ResponseEntity<?> searchLineItem(@PathVariable("id") int id) throws AttributeNotFoundException{
		return ls.searchLineItem(id);
	}

}
