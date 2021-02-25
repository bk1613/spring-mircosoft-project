package com.synex.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long accountId;
	
	@ManyToOne
	@JoinColumn(name="branchId")
	private Branch accountBranch;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	private String accountHolder;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate accountDateOPened;
	
	private double accountBalance;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	@JsonIgnore
	private Customer accountCustomer;

	public Account() {}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Branch getAccountBranch() {
		return accountBranch;
	}

	public void setAccountBranch(Branch accountBranch) {
		this.accountBranch = accountBranch;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public LocalDate getAccountDateOPened() {
		return accountDateOPened;
	}

	public void setAccountDateOPened(LocalDate accountDateOPened) {
		this.accountDateOPened = accountDateOPened;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Customer getAccountCustomer() {
		return accountCustomer;
	}

	public void setAccountCustomer(Customer accountCustomer) {
		this.accountCustomer = accountCustomer;
	}
	
	
	
	
}
