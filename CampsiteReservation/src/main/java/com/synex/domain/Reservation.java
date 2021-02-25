package com.synex.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reservation {

	@Id
	private int reservationId;
	private String name;
	private String email;
	private LocalDate checkindate;
	private LocalDate checkoutdate;
	private Status stats;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getCheckindate() {
		return checkindate;
	}

	public void setCheckindate(LocalDate checkindate) {
		this.checkindate = checkindate;
	}

	public LocalDate getCheckoutdate() {
		return checkoutdate;
	}

	public void setCheckoutdate(LocalDate checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	
	public Status getStats() {
		return stats;
	}

	public void setStats(Status stats) {
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", name=" + name + ", email=" + email + ", checkindate="
				+ checkindate + ", checkoutdate=" + checkoutdate + "]";
	}

	
	
	
}
