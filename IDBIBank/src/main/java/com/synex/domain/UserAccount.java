package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccount {

	@Id
	private int accountId;
	private String accountNumber;
	private Double balance;
	
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "UserAccount [accountId=" + accountId + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ "]";
	}

	
	
	
}
