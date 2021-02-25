package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Allotment {
	
	@Id
	@GeneratedValue
	private int id;
	private String allotFrom;
	private String allotTo;
	
	@ManyToOne
	@JoinColumn(name="stallid")
	private Stall stall;
	
	@ManyToOne
	@JoinColumn(name="vendorid")
	private Vendor vendor;

	public Allotment() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAllotFrom() {
		return allotFrom;
	}

	public void setAllotFrom(String allotFrom) {
		this.allotFrom = allotFrom;
	}

	public String getAllotTo() {
		return allotTo;
	}

	public void setAllotTo(String allotTo) {
		this.allotTo = allotTo;
	}

	public Stall getStall() {
		return stall;
	}

	public void setStall(Stall stall) {
		this.stall = stall;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	
	
}
