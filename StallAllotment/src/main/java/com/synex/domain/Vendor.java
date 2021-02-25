package com.synex.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vendor {

	@Id
	private int vendorid;
	
	private String name;
	
	@OneToMany(mappedBy="vendor")
	private List<Allotment> allotments = new ArrayList<>();

	public Vendor() {
		
	}

	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Allotment> getAllotments() {
		return allotments;
	}

	public void setAllotments(List<Allotment> allotments) {
		this.allotments = allotments;
	}
	
	
}
