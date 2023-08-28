package com.wipro.bank.Model;




import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="BankCustomer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customerId")
	private Long customerId;
	
	private String customerName;
	
	private String customerGender;
	@Temporal(TemporalType.DATE)
	private Date customerDob;
	
	private String customerPan;
	
	private String customerAadhar;
	
	private String customerContact;
	
	private String customerEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="customerId",referencedColumnName="customerId")
	private List<Account> customerAccounts;
	
	public Customer(Long customerId, String customerName, String customerGender, Date customerDob, String customerPan,
			String customerAadhar, String customerContact, String customerEmail, List<Account> customerAccounts) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGender = customerGender;
		this.customerDob = customerDob;
		this.customerPan = customerPan;
		this.customerAadhar = customerAadhar;
		this.customerContact = customerContact;
		this.customerEmail = customerEmail;
		this.customerAccounts = customerAccounts;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public List<Account> getCustomerAccounts() {
		return customerAccounts;
	}

	public void setCustomerAccounts(List<Account> customerAccounts) {
		this.customerAccounts = customerAccounts;
	}

	

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public Date getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}

	public String getCustomerPan() {
		return customerPan;
	}

	public void setCustomerPan(String customerPan) {
		this.customerPan = customerPan;
	}

	public String getCustomerAadhar() {
		return customerAadhar;
	}

	public void setCustomerAadhar(String customerAadhar) {
		this.customerAadhar = customerAadhar;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerGender="
				+ customerGender + ", customerDob=" + customerDob + ", customerPan=" + customerPan + ", customerAadhar="
				+ customerAadhar + ", customerContact=" + customerContact + ", customerEmail=" + customerEmail
				+ ", customerAccounts=" + customerAccounts + "]";
	}	
}
