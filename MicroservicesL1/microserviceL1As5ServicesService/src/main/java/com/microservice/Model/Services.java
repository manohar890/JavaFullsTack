package com.microservice.Model;

public class Services {
	Long id;
	String service_name;	
	Long fees;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public Long getFees() {
		return fees;
	}
	public void setFees(Long fees) {
		this.fees = fees;
	}
	public Services(Long id, String service_name, Long fees) {
		super();
		this.id = id;
		this.service_name = service_name;
		this.fees = fees;
	}
	
	
}

