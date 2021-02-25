package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Product;
import com.synex.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository proRep;

	public Product saveProduct(Product pro) {
		pro = proRep.save(pro);
		return pro;
	}
	
	public List<Product> saveProducts(List<Product> pro) {
		pro = proRep.saveAll(pro);
		return pro;
	}
	
	public List<Product> getAllproduct(){
		
		return proRep.findAll();
	}
	
}
