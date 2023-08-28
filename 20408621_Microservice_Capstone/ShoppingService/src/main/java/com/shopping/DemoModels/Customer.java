package com.shopping.DemoModels;

import java.util.List;
public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerEmail;
	private List<Address> billingAddress;
	private List<Address> shippingAddress;
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerEmail() {
		return customerEmail;
	}



	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}



	public List<Address> getBillingAddress() {
		return billingAddress;
	}



	public void setBillingAddress(List<Address> billingAddress) {
		this.billingAddress = billingAddress;
	}



	public List<Address> getShippingAddress() {
		return shippingAddress;
	}



	public void setShippingAddress(List<Address> shippingAddress) {
		this.shippingAddress = shippingAddress;
	}



	public Customer(int customerId, String customerName, String customerEmail, List<Address> billingAddress,
			List<Address> shippingAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress + "]";
	}

	

}
