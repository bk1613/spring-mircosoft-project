package com.synex.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Table(name="backtransaction")
public class BankTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bankTransactionId;
	
	private Long bankTransactionFromAccount; // can be used for withdrawl, transfer
	
	private Long bankTransactionToAccount; // can be used for deposit, transfer
	
	private double bankTransactionAmount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime  bankTransactionDateTime;
	
	private String comments;

	public BankTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankTransaction(double bankTransactionAmount, TransactionType transactionType,
			LocalDateTime bankTransactionDateTime) {
		super();
		this.bankTransactionAmount = bankTransactionAmount;
		this.transactionType = transactionType;
		this.bankTransactionDateTime = bankTransactionDateTime;
	}

	public BankTransaction(Long bankTransactionToAccount, double bankTransactionAmount, TransactionType transactionType,
			LocalDateTime bankTransactionDateTime) {
		super();
		this.bankTransactionToAccount = bankTransactionToAccount;
		this.bankTransactionAmount = bankTransactionAmount;
		this.transactionType = transactionType;
		this.bankTransactionDateTime = bankTransactionDateTime;
	}

	public BankTransaction(TransactionType transactionType) {
		super();
		this.transactionType = transactionType;
	}

	public Long getBankTransactionId() {
		return bankTransactionId;
	}

	public void setBankTransactionId(Long bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}

	public Long getBankTransactionFromAccount() {
		return bankTransactionFromAccount;
	}

	public void setBankTransactionFromAccount(Long bankTransactionFromAccount) {
		this.bankTransactionFromAccount = bankTransactionFromAccount;
	}

	public Long getBankTransactionToAccount() {
		return bankTransactionToAccount;
	}

	public void setBankTransactionToAccount(Long bankTransactionToAccount) {
		this.bankTransactionToAccount = bankTransactionToAccount;
	}

	public double getBankTransactionAmount() {
		return bankTransactionAmount;
	}

	public void setBankTransactionAmount(double bankTransactionAmount) {
		this.bankTransactionAmount = bankTransactionAmount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDateTime getBankTransactionDateTime() {
		return bankTransactionDateTime;
	}

	public void setBankTransactionDateTime(LocalDateTime bankTransactionDateTime) {
		this.bankTransactionDateTime = bankTransactionDateTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

//	@Override
//	public String toString() {
//		return "BankTransaction [bankTransactionId=" + bankTransactionId + ", bankTransactionFromAccount="
//				+ bankTransactionFromAccount + ", bankTransactionToAccount=" + bankTransactionToAccount
//				+ ", bankTransactionAmount=" + bankTransactionAmount + ", transactionType=" + transactionType
//				+ ", bankTransactionDateTime=" + bankTransactionDateTime + ", comments=" + comments + "]";
//	}
	
	
}
