package com.example.Customer.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BillingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addId;
	@Column
	private String doorNo;
	@Column
	private String streetName;
	@Column
	private String layout;
	@Column
	private String city;
	@Column
	private String pincode;
	public BillingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillingAddress(int addId, String doorNo, String streetName, String layout, String city, String pincode) {
		super();
		this.addId = addId;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.layout = layout;
		this.city = city;
		this.pincode = pincode;
	}
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addId=" + addId + ", doorNo=" + doorNo + ", streetName=" + streetName + ", layout=" + layout
				+ ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
	

}
