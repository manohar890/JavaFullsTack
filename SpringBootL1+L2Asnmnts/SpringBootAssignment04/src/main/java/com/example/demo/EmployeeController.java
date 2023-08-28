package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//Create a Spring Boot Application as per the requirements below:
//a.	The application should display a Form in the landing page (index.page) where the user can enter the ‘Employee’ details like ‘Employee ID’ , ‘Employee Name’ , ‘Employee Email’ and ‘Location’ and upon submission the data should be saved onto a database table
//b.	The application should also support a ‘/displayAll’ path which shows the list of all the registered Employees.
//c.	The application should also support a ‘/display/<userid>’ path where upon passing of userid as the parameter the details of only the particular Employee holding that Employee ID will be displayed.
//d.	Code all the above functionalities required as a RESTful URL.

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository empr;
	
	String s="";
	
	@GetMapping("/")
	public String Addemployee(ModelMap m) {
		Employee e = new Employee(0, null, null, null);
		m.put("S", s);
		m.put("emp", e);
		return "index";
	}
	@PostMapping("/")
	public String Save(ModelMap m,Employee e,BindingResult rs) {
		empr.save(e);
		s="Inserted Successfully....";
		
		return "redirect:/";
	}
	@GetMapping("/displayAll")
	public String displayAll(ModelMap m) {
		List<Employee> lis=empr.findAll();
		m.put("data", lis);
		return "displayAll";
	}
	@GetMapping("/display/{id}")
	public String displayById(@PathVariable("id") int id,ModelMap m) {
		Employee emp=empr.findbyids(id);
		m.put("data", emp);
		return "displaybyid";
		
		
	}
}
