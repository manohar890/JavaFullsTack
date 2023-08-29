package com.example.OnlineTaskMangement.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.OnlineTaskMangement.Dao.EmployeeRepository;
import com.example.OnlineTaskMangement.Entity.Employee;
@Service
public class EmployeeService {
	

	@Autowired
	EmployeeRepository er;
	
	public ResponseEntity<?> addEmployee(Employee add)
	{
		try
		{
			return new ResponseEntity<>(er.save(add),HttpStatus.CREATED);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	public ResponseEntity<Employee> updateEmployee(Employee a,int id){
		Optional<Employee> emp = er.findById(id);
		if (!emp.isEmpty()) {
			Employee ee=emp.get();
			
			return new ResponseEntity<Employee>(er.save(ee),HttpStatus.OK);
		} 
		else 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<List<Employee>>GetAllEmployee()
	{
		List<Employee> list=er.findAll();
		if(!list.isEmpty())
		{
			return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Employee>>(Collections.emptyList(),HttpStatus.NO_CONTENT);
		}
	}
	


}
	
