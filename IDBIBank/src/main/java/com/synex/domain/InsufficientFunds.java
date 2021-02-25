package com.synex.domain;

public class InsufficientFunds extends Exception{

	private String message;
	private double amount;

	public InsufficientFunds(String message, double amount) {
		
		this.message = message;
		this.amount = amount;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
