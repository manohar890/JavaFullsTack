package com.microservice.Model;

import java.util.ArrayList;
import java.util.List;

public class Patients {
	private Long id;
	private String firstname;
	private String lastname;
	private List<Services> services=new ArrayList<Services>();


	public List<Services> getServices() {
		return services;
	}
	public void setServices(List<Services> services) {
		this.services = services;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Patients(Long id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
  public Patients() {
	// TODO Auto-generated constructor stub
}

}