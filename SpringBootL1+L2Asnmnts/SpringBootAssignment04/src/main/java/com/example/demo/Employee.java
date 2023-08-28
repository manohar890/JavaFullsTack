package com.example.demo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String EmpName;
	
	@Column
	private String EmpEmail;
	
	@Column
	private String EmpLocation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmpEmail() {
		return EmpEmail;
	}

	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}

	public String getEmpLocation() {
		return EmpLocation;
	}

	public void setEmpLocation(String empLocation) {
		EmpLocation = empLocation;
	}

	public Employee(int id, String empName, String empEmail, String empLocation) {
		super();
		this.id = id;
		EmpName = empName;
		EmpEmail = empEmail;
		EmpLocation = empLocation;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
