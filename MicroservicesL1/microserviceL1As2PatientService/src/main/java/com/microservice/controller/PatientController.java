package com.microservice.controller;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.microservice.Model.Patients;
import com.microservice.Model.Services;


@RestController
public class PatientController {

	List<Patients> lis1=new ArrayList<Patients>();
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/getAllPatients")
	public List<Patients> getAllPatients(){
		return lis1;
	}
	@PostMapping("/addPatient")
	public Patients addPatient(Patients p) {
		lis1.add(p);
		return p;
	}
@PostMapping("/addService")
public String addService(@RequestBody Services ob) {
	 HttpHeaders http = new HttpHeaders();
	 http.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 
	String resourceUrl
    = "http://localhost:8081/addService";
	HttpEntity<Object> request = 
	          new HttpEntity<Object>(ob,http);
	return
         restTemplate
             .exchange(resourceUrl, 
                 HttpMethod.POST, 
                 request, 
                 String.class).getBody();
	
  }
@GetMapping("/allServices")
public String getAllServices() {
	HttpHeaders http=new HttpHeaders();
	http.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	String resourceUrl= "http://localhost:8081/allServices";
	HttpEntity<Object> request = new HttpEntity<Object>(http);
	return
	         restTemplate
	             .exchange(resourceUrl, 
	                 HttpMethod.GET, 
	                 request,
	                 String.class).getBody();
}
}
