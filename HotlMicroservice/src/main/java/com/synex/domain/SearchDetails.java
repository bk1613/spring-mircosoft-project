package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class SearchDetails {
	
	private String searchHotel;
	private String checkin;
	private String checkOut;
	private int noOfRooms;
	private int noOfGuests;
	
	public SearchDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSearchHotel() {
		return searchHotel;
	}

	public void setSearchHotel(String searchHotel) {
		this.searchHotel = searchHotel;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public int getNoOfGuests() {
		return noOfGuests;
	}

	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	@Override
	public String toString() {
		return "SearchDetails [searchHotel=" + searchHotel + ", checkin=" + checkin + ", checkOut=" + checkOut
				+ ", noOfRooms=" + noOfRooms + ", noOfGuests=" + noOfGuests + "]";
	}

}
