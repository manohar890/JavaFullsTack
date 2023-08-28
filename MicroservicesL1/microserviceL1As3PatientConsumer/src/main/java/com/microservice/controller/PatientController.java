package com.microservice.controller;



import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.Model.Patients;
import com.microservice.Model.Services;


@RestController
public class PatientController {
	@Autowired
	private ServiceData data;

	List<Patients> lis1=new ArrayList<Patients>();
	
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
	 return data.addService(ob);
	
  }
@GetMapping("/allServices")
public List<Services> getAllServices() {
	return data.getAllServices();
}
}
