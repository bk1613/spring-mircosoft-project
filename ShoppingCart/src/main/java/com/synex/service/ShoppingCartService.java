package com.synex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Cart;
import com.synex.domain.Invoice;
import com.synex.domain.Product;
import com.synex.domain.User;
import com.synex.repository.CartRepository;
import com.synex.repository.InvoiceRepository;
import com.synex.repository.ProductRepository;
import com.synex.repository.UserRepository;

@Service
public class ShoppingCartService {

	@Autowired
	ProductRepository proRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	InvoiceRepository InvRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public Product saveProduct(Product pro) {
		
		
		return proRepo.save(pro);
	}
	
	public Cart saveCart(int id) {
		Cart cart = new Cart();
		cart.setCartid(id);
		return cartRepo.save(cart);
	};
	
	public Invoice saveInvocie(Cart cart) {
		Invoice inv = new Invoice();
		inv.setInvoiceid(cart.getCartid());
		int total = 0;
		for(Product c: cart.getList()) {
			total += c.getPrice();
		}
		inv.setTotalprice(total);
		inv.setCart(cart);
		return InvRepo.save(inv);
	};
	
	public Product findproduct(int id) {
		
		Optional<Product> pro = proRepo.findById(id);
		
		return pro.get();
		
	}
	
	public Cart findcart(int id) {
		
		Optional<Cart> pro = cartRepo.findById(id);
		if(pro.isPresent()) {
			return pro.get();
			}else {
				
				return null;
			}
		
		
	}
	
	public Invoice findInvoice(int id) {
		
		Optional<Invoice> inv = InvRepo.findById(id);
		if(inv.isPresent()) {
			return inv.get();
		}else {
			return null;
		}

	}
	
	public User finduser(int id) {
		Optional<User> inv = userRepo.findById(id);
		if(inv.isPresent()) {
			return inv.get();
		}else {
			return null;
		}
	}
}
