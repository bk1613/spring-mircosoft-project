package com.synex.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
public class Hotel {
	@Id
	private int hotelId;
	private String hotelName;
	private String address;	
	private String city;
	private String state;
	private int starRating;
	private double averagePrice;
	private double discount;
	private String description;
	private String email;
	private String mobile;
	private String imageURL;	
	private int timesBooked;
	
	@ManyToMany
	private Set<Amenities> amenities = new HashSet<>();
	
	@OneToMany
	private Set<HotelRoom> hotelRooms = new HashSet<>();
	
	@Transient
	private Set<String> hotelAmenityNames = new HashSet<>();
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(int hotelId, String hotelName) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
	}
	
	public Hotel(int hotelId, String hotelName, String city, String state) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
		this.state = state;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	public double getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public int getTimesBooked() {
		return timesBooked;
	}
	public void setTimesBooked(int timesBooked) {
		this.timesBooked = timesBooked;
	}
	public Set<Amenities> getAmenities() {
		return amenities;
	}
	public void setAmenities(Set<Amenities> amenities) {
		this.amenities = amenities;
	}
	public Set<HotelRoom> getHotelRooms() {
		return hotelRooms;
	}
	public void setHotelRooms(Set<HotelRoom> hotelRooms) {
		this.hotelRooms = hotelRooms;
	}
	public Set<String> getHotelAmenityNames() {
		return hotelAmenityNames;
	}
	public void setHotelAmenityNames(Set<String> hotelAmenityNames) {
		this.hotelAmenityNames = hotelAmenityNames;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", starRating=" + starRating + ", averagePrice=" + averagePrice + ", discount="
				+ discount + ", description=" + description + ", email=" + email + ", mobile=" + mobile + ", imageURL="
				+ imageURL + ", timesBooked=" + timesBooked + ", amenities=" + amenities + ", hotelRooms=" + hotelRooms
				+ ", hotelAmenityNames=" + hotelAmenityNames + "]";
	}
	
	
}
