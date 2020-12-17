package com.synex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String moblie;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String name, String moblie) {
		super();
		this.id = id;
		this.name = name;
		this.moblie = moblie;
	}

	public Person(String name, String moblie) {
		super();
		this.name = name;
		this.moblie = moblie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMoblie() {
		return moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", moblie=" + moblie + "]";
	}
	
	
}
