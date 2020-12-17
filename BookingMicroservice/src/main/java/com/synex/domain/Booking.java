package com.synex.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private int hotelId; //communicates with hotel management to fetch hotel details
	private int hotelRoomId;	
	private int noRooms;
	private String userName;
	@ManyToMany
	(cascade = {CascadeType.ALL})
	private Set<Guest> guests;
	private String checkInDate;
	private String checkOutDate;
	private String bookedOnDate;
	private String status; //cancelled, completed (can be simply compared), upcoming
	private float price;
	private float discount;	
	private String customerMobile; //identify the customer who booked
	private String roomType;
	private String email;
	@Transient
	private String hotelName;
	@Transient
	private String address;
	@Transient
	private String city;
	@Transient
	private String state;
	@Transient
	private String imageURL;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getHotelRoomId() {
		return hotelRoomId;
	}

	public void setHotelRoomId(int hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}

	public int getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}

	public Set<Guest> getGuests() {
		return guests;
	}

	public void setGuests(Set<Guest> guests) {
		this.guests = guests;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getBookedOnDate() {
		return bookedOnDate;
	}

	public void setBookedOnDate(String bookedOnDate) {
		this.bookedOnDate = bookedOnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", hotelId=" + hotelId + ", hotelRoomId=" + hotelRoomId
				+ ", noRooms=" + noRooms + ", userName=" + userName + ", guests=" + guests + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + ", bookedOnDate=" + bookedOnDate + ", status="
				+ status + ", price=" + price + ", discount=" + discount + ", customerMobile=" + customerMobile
				+ ", roomType=" + roomType + ", hotelName=" + hotelName + "]";
	}

	
	
}
