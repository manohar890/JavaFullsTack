package com.wipro.bank.exception;

public class InternalServerException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	private int status=500;
	
	private String message="Internal Server Error";

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InternalServerException() {
		// TODO Auto-generated constructor stub
	}
		

}
