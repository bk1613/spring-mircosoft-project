package com.synex.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue()
	private int cartid;
	
	@OneToMany(mappedBy="cart")
//	@JoinColumn(name="productid")
	private Set<Product> list = new HashSet<>();
	

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public Set<Product> getList() {
		return list;
	}

	public void setList(Set<Product> list) {
		this.list = list;
	}

	
	
	
	
}
