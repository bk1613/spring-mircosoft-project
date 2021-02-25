package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laundryitems {
	@Id
	int itemId;
	String itemname;
	int type;
	double rate;
	
	public Laundryitems() {
		super();
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	
	
	
}
