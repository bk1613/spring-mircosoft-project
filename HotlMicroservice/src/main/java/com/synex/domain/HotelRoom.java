package com.synex.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class HotelRoom {
	
	 @Id
	 private int roomId;
	 private String area;
	 private double price;
	 private double discount;
	 private String description;
	 private String policy;
	 private int totalroom;
	 private String roomImage;
	 @ManyToOne
	 private RoomType type;
	    
	 @ManyToMany
	 private Set<Amenities> amenities = new HashSet<>();

	public HotelRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public int getTotalroom() {
		return totalroom;
	}

	public void setTotalroom(int totalroom) {
		this.totalroom = totalroom;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public Set<Amenities> getAmenities() {
		return amenities;
	}

	public void setAmenities(Set<Amenities> amenities) {
		this.amenities = amenities;
	}
	

	public String getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(String roomImage) {
		this.roomImage = roomImage;
	}

	@Override
	public String toString() {
		return "HotelRoom [roomId=" + roomId + ", area=" + area + ", price=" + price + ", discount=" + discount
				+ ", description=" + description + ", policy=" + policy + ", totalroom=" + totalroom + ", roomImage="
				+ roomImage + ", type=" + type + ", amenities=" + amenities + "]";
	}

	
	
	 
}
