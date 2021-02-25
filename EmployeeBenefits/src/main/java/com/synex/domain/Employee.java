package com.synex.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int empId;
	private String name;
	private double salary;
	private int dependent;

	final int payment = 2000;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDependent() {
		return dependent;
	}

	public void setDependent(int dependent) {
		this.dependent = dependent;
	}

	public int getPayment() {
		return payment;
	}

	
	
}
