package com.synex.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stall {
	
	@Id
	private int stallid;
	
	private String name;
	
	@OneToMany(mappedBy="stall")
	private List<Allotment> allotments = new ArrayList<>();

	public Stall() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStallid() {
		return stallid;
	}

	public void setStallid(int stallid) {
		this.stallid = stallid;
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
