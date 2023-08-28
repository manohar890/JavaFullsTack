package com.example.Customer.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId;
	@Column
	private String customerName;
	@Column
	private String customerEmail;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "customerId" ,name="cid")
	private List<BillingAddress> billingAddress;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "customerId",name="cid")
	private List<ShippingAddress> shippingAddress;
	
	

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



	public List<BillingAddress> getBillingAddress() {
		return billingAddress;
	}



	public void setBillingAddress(List<BillingAddress> billingAddress) {
		this.billingAddress = billingAddress;
	}



	public List<ShippingAddress> getShippingAddress() {
		return shippingAddress;
	}



	public void setShippingAddress(List<ShippingAddress> shippingAddress) {
		this.shippingAddress = shippingAddress;
	}



	public Customer(int customerId, String customerName, String customerEmail, List<BillingAddress> billingAddress,
			List<ShippingAddress> shippingAddress) {
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
