package com.example.demo;

public class Employee {

	 private int id;
	private String EmpName;
	private String EmpEmail;
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", EmpName=" + EmpName + ", EmpEmail=" + EmpEmail + ", EmpLocation=" + EmpLocation
				+ "]";
	}
	
}
