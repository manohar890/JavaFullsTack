package com.example.demo;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public static Map<Integer, Employee> EmpDetails=new TreeMap<Integer,Employee>();
	public static int id =0;
	
	public Map<Integer, Employee> getDetails(){
		return EmpDetails;
	}
	public String AddEmployee(Employee e) {

		++id;
		e.setId(id);
		EmpDetails.put(id, e);
		return e.toString()+"			\nAdded Successsfully";	
	}
	
	public Employee Update(Employee e) {
		Employee emp=EmpDetails.get(e.getId());
		emp.setEmpName(e.getEmpName());
		emp.setEmpEmail(e.getEmpEmail());
		emp.setEmpLocation(e.getEmpLocation());
		EmpDetails.remove(e.getId());
		EmpDetails.put(e.getId(), emp);
		return emp;
	}
	public String Delete(int id) {
		if(EmpDetails.containsKey(id)) {
			Employee emp=EmpDetails.get(id);
			EmpDetails.remove(id);
			return emp.toString()+" \nDeleted Succesfully...";
		}
		return "Id Not Found";
	}
}
