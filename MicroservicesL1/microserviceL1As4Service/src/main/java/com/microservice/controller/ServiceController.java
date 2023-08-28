package com.microservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.Model.Services;

@RestController
public class ServiceController {

	List<Services> lis= new ArrayList<Services>();;
	
	@PostMapping("/addService")
	public Services addService(@RequestBody Services obj) {
		
		lis.add(obj);
		System.out.println("Object added successfully");
		return obj;
	}
	@GetMapping("/allServices")
	public List<Services> allService(Services obj) {
		return lis;
	}
}
