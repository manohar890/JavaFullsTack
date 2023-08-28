package com.shopping.DemoModels;

import java.util.List;

public class ListOrders {

	private Customer CustomerDetails;
	private List<Orders> Orders;
	public Customer getCustomerDetails() {
		return CustomerDetails;
	}
	public void setCustomerDetails(Customer customerDetails) {
		CustomerDetails = customerDetails;
	}
	public List<Orders> getOrders() {
		return Orders;
	}
	public void setOrders(List<Orders> orders) {
		Orders = orders;
	}
	
	
}
