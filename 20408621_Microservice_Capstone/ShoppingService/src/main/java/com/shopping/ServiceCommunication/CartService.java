package com.shopping.ServiceCommunication;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopping.DemoModels.Cart;
import com.shopping.DemoModels.Lineitem;

@FeignClient(name="Cart")
public interface CartService {

	@PostMapping("/Cart/addCart")
	public Cart addCart(@RequestBody Cart cart);
	
	@PutMapping("/Cart/updateCart/{id}")
	public ResponseEntity<?> updateCart(@RequestBody Cart c,@PathVariable("id") int id);
	
	@GetMapping("/Cart/searchCart/{id}")
	public List<Lineitem> getAll(@PathVariable("id") int id);
	
	@PutMapping("/Cart/updateCarts/{id}")
	public ResponseEntity<?> UpdateCarts(@RequestBody Cart c,@PathVariable("id") int id);
}
