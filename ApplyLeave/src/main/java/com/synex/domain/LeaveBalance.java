package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LeaveBalance {

	@Id
	@GeneratedValue
	private int balId;
	private int empId;
	private String leaveType;
	private double balance;
	private String leaveYear;
	
	public LeaveBalance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBalId() {
		return balId;
	}

	public void setBalId(int balId) {
		this.balId = balId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getLeaveYear() {
		return leaveYear;
	}

	public void setLeaveYear(String leaveYear) {
		this.leaveYear = leaveYear;
	}

	@Override
	public String toString() {
		return "LeaveBalance [balId=" + balId + ", empId=" + empId + ", leaveType=" + leaveType + ", balance=" + balance
				+ ", leaveYear=" + leaveYear + "]";
	}

	
	
}
