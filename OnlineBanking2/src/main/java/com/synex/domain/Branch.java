package com.synex.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="branch")
public class Branch {
	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long branchId;
	
	@Column(name="branchname")
	@NotEmpty
	private String branchName;
	
	@Valid
	@Embedded
	private Address branchAddress;
	
	@OneToMany(mappedBy="accountBranch")
	@JsonIgnore
	List<Account> branchAccounts = new ArrayList<>();

	public Branch() {
	}

	public Branch(String branchName) {
		super();
		this.branchName = branchName;
	}

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Address getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(Address branchAddress) {
		this.branchAddress = branchAddress;
	}

	public List<Account> getBranchAccounts() {
		return branchAccounts;
	}

	public void setBranchAccounts(List<Account> branchAccounts) {
		this.branchAccounts = branchAccounts;
	}

//	@Override
//	public String toString() {
//		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", branchAddress=" + branchAddress + "]";
//	}
	
	
	
}
