package com.synex.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateAvaiavble {

	private LocalDate date;
	private Status status;
	
	public DateAvaiavble() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DateAvaiavble [date=" + date + ", status=" + status + "]";
	}
	
	
}
