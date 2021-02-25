package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Product;
import com.synex.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService proSer;
	
	@PostMapping(value="saveProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product pro){
		
		pro = proSer.savePro(pro);
		return new ResponseEntity<Product>(pro, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="findallProducts", produces="application/json")
	public ResponseEntity<List<Product>> findAllProduct(){
		List<Product> list = proSer.findAllproduct();
		return new ResponseEntity<List<Product>>(list, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="findproduct/{id}", produces="application/json")
	public ResponseEntity<?> findProduct(@PathVariable int id){
		Product pro = proSer.findproduct(id);
		if(pro == null) {
			return new ResponseEntity<String>("Not Found", HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<Product>(pro, HttpStatus.ACCEPTED);
	}
	
	
}

