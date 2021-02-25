package com.synex.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerId;
	
	private String customerName;
	
	private String customerGender;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate customerDob;
	
	private String customerMoblieNo;
	
	private String customerPhone;
	
	@Embedded
	private Address customerAddess;
	
	private String customerssn;
	
	@OneToMany
	@JoinColumn(name="accountId")
	@JsonIgnore
	private List<Account> customerAccounts = new ArrayList<>();
	
	

	@OneToOne
	@JoinColumn(name="userID")
	@JsonIgnore
	private User user;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
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

	public LocalDate getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(LocalDate customerDob) {
		this.customerDob = customerDob;
	}

	public String getCustomerMoblieNo() {
		return customerMoblieNo;
	}

	public void setCustomerMoblieNo(String customerMoblieNo) {
		this.customerMoblieNo = customerMoblieNo;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Address getCustomerAddess() {
		return customerAddess;
	}

	public void setCustomerAddess(Address customerAddess) {
		this.customerAddess = customerAddess;
	}

	

	public List<Account> getCustomerAccounts() {
		return customerAccounts;
	}

	public void setCustomerAccounts(List<Account> customerAccounts) {
		this.customerAccounts = customerAccounts;
	}
	public String getCustomerssn() {
		return customerssn;
	}
	
	public void setCustomerssn(String customerssn) {
		this.customerssn = customerssn;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
