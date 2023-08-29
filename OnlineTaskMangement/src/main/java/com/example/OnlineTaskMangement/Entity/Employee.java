package com.example.OnlineTaskMangement.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "your_sequence")    
	@SequenceGenerator(name = "your_sequence", sequenceName = "your_sequence_name", initialValue = 10000, allocationSize = 1)
	private int empId;
	@Column
	private String empName;
	@Column
	private String password;
	@Column
	private String confirmPassword;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, String password, String confirmPassword) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}
	
	
	
	
	
}