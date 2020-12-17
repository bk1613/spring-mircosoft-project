package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int guestId;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guest(String firstName, String lastName, String gender, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}



	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", age=" + age + "]";
	}
	
	
}
