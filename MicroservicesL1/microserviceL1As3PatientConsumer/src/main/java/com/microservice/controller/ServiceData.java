package com.microservice.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.Model.Services;

@FeignClient(name="serviceProvider",url = "http://localhost:8081/")
public interface ServiceData {
	
	@PostMapping("/addService")
	public String addService(@RequestBody Services s);
	
	@GetMapping("/allServices")
	public List<Services> getAllServices();

}
