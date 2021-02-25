package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Product;
import com.synex.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository prorepo;
	
	public Product savePro(Product pro) {
		return prorepo.save(pro);
	}
	
	public Product findproduct(int id) {
		Optional<Product> proop = prorepo.findById(id);
		if(proop.get() == null) {
			return null;
		}else {
			return proop.get();
		}
	}
	
	public List<Product> findAllproduct(){
		return prorepo.findAll();
	}
}

