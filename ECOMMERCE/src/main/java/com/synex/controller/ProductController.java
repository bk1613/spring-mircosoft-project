package com.synex.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synex.domain.Product;
import com.synex.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService proSer;
	
	@Autowired
	ResourceLoader resourceloader;
	
//	@PostMapping(value="saveProduct", produces="application/json", consumes="application/json")
//	public ResponseEntity<Product> saveProduct(@RequestBody Product pro){
//		System.out.println(pro);
//		pro = proSer.saveProduct(pro);
//		return new ResponseEntity<Product>(pro, HttpStatus.ACCEPTED);
//	}
	@PostMapping(value="saveProduct")
	public ResponseEntity<Product> saveProduct(){
		
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Product>> mapType = new TypeReference<List<Product>>() {};
		
		Resource resource = resourceloader.getResource("classpath:static/json/product.json");
		
		try {
			InputStream is = resource.getInputStream();
			
			String data = new String(FileCopyUtils.copyToByteArray(is));
			
			JSONArray jsonarray = new JSONArray(data);
			
			for(int i = 0; i < jsonarray.length(); i++) {
				
				JSONObject jsonObject = jsonarray.getJSONObject(i);
				
				Product p = new Product();
				
				p.setProductName(jsonObject.getString("productName"));
				p.setCategory(jsonObject.getString("category"));
				p.setCost(jsonObject.getDouble("cost"));
				p.setBrand(jsonObject.getString("brand"));
				
				proSer.saveProduct(p);
			}
	       
			System.out.println("Products list saved successfully");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}	
		return new ResponseEntity<Product>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="getProducts", produces="application/json")
	public ResponseEntity<List<Product>> getAllProducts(){
		System.out.println("products");
		List<Product> list = proSer.getAllproduct();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	

}
