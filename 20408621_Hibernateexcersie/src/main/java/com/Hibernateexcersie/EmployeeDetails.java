//Column Name Type Constraint
//
//Empcode Number (4) Primary Key
//
//EmpName Varchar (20) Not Null
//
//EmpDesignation Varchar (4) Not Null
//
//EmpDOB Date Not Null
//
//EmpJOD Date Not Null
//
//EmpAge Number (2) Not Null
//
//EmpBasic_Pay Decimal (8,2) Not Null

package com.Hibernateexcersie;



import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="EmployeeDetails")
public class EmployeeDetails {

	@Id 
	@Column(name="EmpCode")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="EmpName")
	@NotNull(message = "Ooops Name should not be null")
	@Size(max = 20, min = 3, message = "Invalid Name, Size should be between 3 to 20")
	private String empName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="EmpDesignation")
	@NotNull(message="Employee designation should not be null")
	private EmpDesignation empDesignation;
	
	@Column(name="EmpDoB")
	@NotNull(message="Employee date of birth should not be null")
	@PastOrPresent(message="Date of birth should not be in future")
	@Temporal(TemporalType.DATE)
	private Date empDob ;
	
	@Column(name="EmpJod")
	@NotNull(message="Employee joining date Should not be null")
	@PastOrPresent(message="Joining date should not be in future")
	@Temporal(TemporalType.DATE)
	private Date empJod;
	

	@Column(name="EmpAge")
	@NotNull(message="Employee age should not be null")
	@Range(min = 18, max = 60, message = "Invalid age is given, age should be between 18 to 60")
	private int empAge;
	
	@Column(name="EmpBasicSalary")
	@NotNull(message="Employee basic salary should not be null")
	@Min(value=6000,message="employee basic salary should be greater than 6000")
	private Long empBasicSalary;

	public long getId() {
		return id;
	}
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public EmpDesignation getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(EmpDesignation empDesignation) {
		this.empDesignation = empDesignation;
	}

	public Date getEmpDob() {
		return empDob;
	}

	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	public Date getEmpJod() {
		return empJod;
	}

	public void setEmpJod(Date empJod) {
		this.empJod = empJod;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int l) {
		this.empAge = l;
	}

	public long getEmpBasicSalary() {
		return empBasicSalary;
	}

	public void setEmpBasicSalary(long empBasicSalary) {
		this.empBasicSalary = empBasicSalary;
	}
	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDetails(long id, String empName, EmpDesignation empDesignation,Date date, Date empJod, int empAge,
			long empBasicSalary) {
		super();
		this.id = id;
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.empDob = date;
		this.empJod = empJod;
		this.empAge = empAge;
		this.empBasicSalary = empBasicSalary;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", empName=" + empName + ", empDesignation=" + empDesignation + ", empDob="
				+ empDob + ", empJod=" + empJod + ", empAge=" + empAge + ", empBasicSalary=" + empBasicSalary + "]";
	}
	
	
	
}
