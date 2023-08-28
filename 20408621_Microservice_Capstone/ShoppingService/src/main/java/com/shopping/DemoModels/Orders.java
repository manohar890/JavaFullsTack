package com.shopping.DemoModels;

import java.util.List;




public class Orders {
	
	private int orderId;
	private List<Lineitem> listitem;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int orderId, List<Lineitem> listitem) {
		super();
		this.orderId = orderId;
		this.listitem = listitem;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Lineitem> getListitem() {
		return listitem;
	}
	public void setListitem(List<Lineitem> listitem) {
		this.listitem = listitem;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", listitem=" + listitem + "]";
	}
	
	


}
