package com.synex.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Request {

	@Id
	@GeneratedValue()
	private int requestid;
	private String name;
	private int numberofitems;
	
	@OneToMany
	List<Items> list = new ArrayList<>();
	
//	@ManyToOne
//	@JoinColumn(name="orderid")
//	Order order;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberofitems() {
		return numberofitems;
	}

	public void setNumberofitems(int numberofitems) {
		this.numberofitems = numberofitems;
	}

	public List<Items> getList() {
		return list;
	}

	public void setList(List<Items> list) {
		this.list = list;
	}
	
	
}
