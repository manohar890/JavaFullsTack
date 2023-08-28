package com.example.Inventory.Controller;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Inventory.Dao.InventoryRepository;
import com.example.Inventory.Model.Inventory;
import com.example.Inventory.Service.InventoryService;

@RestController
@RequestMapping("/Inventory")
public class InventoryController {
	
	@Autowired
	InventoryService is;
	
	@Autowired
	InventoryRepository ir;
	
	static int i=0;
	@PostMapping("/addinventory")
	public ResponseEntity<?> addinventory(@RequestBody Inventory in)
	{
		in.setProductId(++i);
		System.out.println(in.toString());
		return is.addinventory(in);
	}
	
	
	@DeleteMapping("/deleteinventory/{id}")
	public ResponseEntity<?> deleteinventory(@PathVariable("id") int id)
	{
		return is.deleteinventory(id);
		
	}
	
	@PutMapping("/updateinventory/{id}")
	public ResponseEntity<?> updateinventory(@RequestBody  Inventory add,@PathVariable("id") int id) throws AttributeNotFoundException{
		return is.updateInventory(add, id);
	}

	@GetMapping("/searchinventory/{id}")
	public ResponseEntity<?> searchinventory(@PathVariable("id") int id) throws AttributeNotFoundException{
		return is.searchInventory(id);
	}
	@GetMapping("/searchByproductid/{id}")
	public Inventory searchByProductId(@PathVariable("id") int id) {
		return ir.findByProductId(id).get();
	}

}
