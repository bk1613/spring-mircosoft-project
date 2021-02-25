package com.synex.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Cart;
import com.synex.domain.Invoice;
import com.synex.domain.Product;
import com.synex.domain.User;
import com.synex.service.ShoppingCartService;

@RestController
public class ShoppingCartController {

	@Autowired
	ShoppingCartService shcartser;
	
	@PostMapping("addproduct/{id}")
	public ResponseEntity<Product> addProduct(@RequestBody Product pro, @PathVariable int id){
		
		Cart cart = shcartser.findcart(id);
		System.out.println(cart);
		Invoice in = new Invoice();
		if(cart == null) {
			cart = shcartser.saveCart(id);
			
		}
		pro.setCart(cart);
		
		pro = shcartser.saveProduct(pro);
		in = shcartser.saveInvocie(cart);
		return new ResponseEntity<Product>(pro, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("editproduct/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product pro, @PathVariable int id){
		Product probyid = shcartser.findproduct(pro.getId());
		Cart cart = shcartser.findcart(id);
		
		
		if(cart == null) {
			cart = shcartser.saveCart(id);
		}
		pro.setCart(cart);
		if(probyid != null) {
			pro = shcartser.saveProduct(pro);
		}
		
		
		return new ResponseEntity<Product>(pro, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getcart")
	public ResponseEntity<Set<Product>> getCart(){
		System.out.println("cart");
		Cart car = shcartser.findcart(1);
		Set<Product> prolist = car.getList();
		System.out.println(prolist);
		return new ResponseEntity<Set<Product>>(prolist, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("getInvoice/{id}")
	public ResponseEntity<Invoice> getInvoice(@PathVariable int id){
		User user = shcartser.finduser(id);
		Invoice inv = shcartser.findInvoice(user.getInvoice().getInvoiceid());
		
		return new ResponseEntity<Invoice>(inv, HttpStatus.ACCEPTED);
	}
	
}
