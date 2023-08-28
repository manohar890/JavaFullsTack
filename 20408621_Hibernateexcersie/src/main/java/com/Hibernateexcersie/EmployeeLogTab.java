package com.Hibernateexcersie;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="EmployeeLogTable")
public class EmployeeLogTab {

	public EmployeeLogTab(long id, String name,String empdes, long salary, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.empdes = empdes;
		this.salary = salary;
		this.date = date;
	}

	@Id
	@Column(name="EmpCode")
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpdes() {
		return empdes;
	}

	public void setEmpdes(String empdes) {
		this.empdes = empdes;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="EmployeeName")
	private String name;
	
	
	@Column(name="Designation")
	private String empdes;
	
	@Column(name="LastDrawnSalary")
	private long salary;
	
	@Column(name="ResignationDate")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public EmployeeLogTab() {
		// TODO Auto-generated constructor stub
	}
}
