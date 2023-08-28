package com.shopping.DemoModels;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerAndOrderMapping {
	
	private int customerId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public CustomerAndOrderMapping(int customerId, int orderId) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
	}

	public CustomerAndOrderMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
