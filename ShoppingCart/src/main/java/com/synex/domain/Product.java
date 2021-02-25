package com.synex.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	private int productid;
	private String name;
	private String category;
	private double price;

	@ManyToOne
	@JoinColumn(name="cartid")
	private Cart cart;
	

	
	public Product() {
		
	}

	public int getId() {
		return productid;
	}

	public void setId(int id) {
		this.productid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	

	


	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", cart=" + cart + "]";
	}
	
	

}
