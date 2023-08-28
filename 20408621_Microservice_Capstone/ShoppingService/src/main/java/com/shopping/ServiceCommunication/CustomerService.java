package com.shopping.ServiceCommunication;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopping.DemoModels.Customer;

@FeignClient(name="Customer")
public interface CustomerService {

	@PostMapping("/Customer/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer cus);
	
	@GetMapping("/Customer/searchCustomer/{id}")
	public ResponseEntity<Optional<Customer>> searchCustomer(@PathVariable("id") int id);
}
