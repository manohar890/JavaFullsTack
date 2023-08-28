package com.shopping.DemoModels;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
public class Cart {
	@Id
	private int cartId;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "cartId",name= "id")
	private List<Lineitem> listitem;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cartId, List<Lineitem> listitem) {
		super();
		this.cartId = cartId;
		this.listitem = listitem;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<Lineitem> getListitem() {
		return listitem;
	}
	public void setListitem(List<Lineitem> listitem) {
		this.listitem = listitem;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + "]";
	}
	
	
	
	

}
