package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Items {
	
	@Id
	@GeneratedValue()
	private int itemId;
	private String name;
	private String type;
	private double rate;
	
	@ManyToOne
	@JoinColumn(name="requestid")
	Request req;

	public Items() {
		
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Request getReq() {
		return req;
	}

	public void setReq(Request req) {
		this.req = req;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", name=" + name + ", type=" + type + ", rate=" + rate + "]";
	}
	
	

}
