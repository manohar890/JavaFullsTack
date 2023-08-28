package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;

	@GetMapping("/get")
	public Map<Integer,Employee> GetEmployees() {
		return es.getDetails();
	}
	@PostMapping("/Add")
	public String AddEmployee(@RequestBody Employee e) {
		return es.AddEmployee(e);
		
	}
	@PutMapping("/update")
	public String UpdateEmployee(@RequestBody Employee e) { 
		return es.Update(e).toString()+"\n Updated Successfully...... ";
	}
	
	@DeleteMapping("/delete/{id}")
	public String DeleteEmployee(@PathVariable("id") int id) {
		return es.Delete(id);
	}
}
