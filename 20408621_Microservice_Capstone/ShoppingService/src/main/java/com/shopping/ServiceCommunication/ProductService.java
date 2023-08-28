package com.shopping.ServiceCommunication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopping.DemoModels.Product;

@FeignClient(name="ProductService")
public interface ProductService {

	@PostMapping("/Product/addproduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product);
}
