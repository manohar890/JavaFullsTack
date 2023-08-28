package com.wipro.bank.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TransactionHistory")
public class TransactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	
	private Long framAccountNo;
	
	private Long toAccountNo;
	
	private double transactionAmount;
	
	private Date transactioDate;
	
	private String transactionstatus;

	public String getTransactionstatus() {
		return transactionstatus;
	}
	
	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public void setTransactionstatus(String transactionstatus) {
		this.transactionstatus = transactionstatus;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getFramAccountNo() {
		return framAccountNo;
	}

	public void setFramAccountNo(Long framAccountNo) {
		this.framAccountNo = framAccountNo;
	}

	public Long getToAccountNo() {
		return toAccountNo;
	}

	public void setToAccountNo(Long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}

	public Date getTransactioDate() {
		return transactioDate;
	}

	public void setTransactioDate(Date transactioDate) {
		this.transactioDate = transactioDate;
	}

	public TransactionHistory(Long framAccountNo, Long toAccountNo, double amt,String transactionstatus,Date transactioDate) {
		super();
		
		this.framAccountNo = framAccountNo;
		this.toAccountNo = toAccountNo;
		this.transactioDate = transactioDate;
		this.transactionstatus=transactionstatus;
		transactionAmount=amt;
	}

	public TransactionHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
