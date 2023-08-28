package com.shopping.ServiceCommunication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopping.DemoModels.Inventory;



@FeignClient(name="Inventory")
public interface InventoryService {

	@PostMapping("/Inventory/addinventory")
	public Inventory addInventory(@RequestBody Inventory inventory);
	
	@GetMapping("/Inventory/searchByproductid/{id}")
	public Inventory getInventory(@PathVariable("id") int id);
	
	@PutMapping("/Inventory/updateinventory/{id}")
	public Inventory updateInventory(Inventory in,@PathVariable("id") int id);
}
