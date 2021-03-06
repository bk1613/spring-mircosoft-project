package com.synex.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemId;
	private String itemName;
	private String itemEnterByUser;
	private Date itemEnterDate;
	private double itemBuyingPrice;
	private double itemSellingPrice;
	private Date itemLastModifiedDate;
	private String itemLastModifiedNyUser;
	private Status itemStatus;
	
	public Item() {
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemEnterByUser() {
		return itemEnterByUser;
	}

	public void setItemEnterByUser(String itemEnterByUser) {
		this.itemEnterByUser = itemEnterByUser;
	}

	public Date getItemEnterDate() {
		return itemEnterDate;
	}

	public void setItemEnterDate(Date itemEnterDate) {
		this.itemEnterDate = itemEnterDate;
	}

	public double getItemBuyingPrice() {
		return itemBuyingPrice;
	}

	public void setItemBuyingPrice(double itemBuyingPrice) {
		this.itemBuyingPrice = itemBuyingPrice;
	}

	public double getItemSellingPrice() {
		return itemSellingPrice;
	}

	public void setItemSellingPrice(double itemSellingPrice) {
		this.itemSellingPrice = itemSellingPrice;
	}

	public Date getItemLastModifiedDate() {
		return itemLastModifiedDate;
	}

	public void setItemLastModifiedDate(Date itemLastModifiedDate) {
		this.itemLastModifiedDate = itemLastModifiedDate;
	}

	public String getItemLastModifiedNyUser() {
		return itemLastModifiedNyUser;
	}

	public void setItemLastModifiedNyUser(String itemLastModifiedNyUser) {
		this.itemLastModifiedNyUser = itemLastModifiedNyUser;
	}

	public Status getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Status itemStatus) {
		this.itemStatus = itemStatus;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemEnterByUser=" + itemEnterByUser
				+ ", itemEnterDate=" + itemEnterDate + ", itemBuyingPrice=" + itemBuyingPrice + ", itemSellingPrice="
				+ itemSellingPrice + ", itemLastModifiedDate=" + itemLastModifiedDate + ", itemLastModifiedNyUser="
				+ itemLastModifiedNyUser + ", itemStatus=" + itemStatus + "]";
	}
	
	

}
