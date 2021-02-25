package com.synex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synex.domain.Items;



@Controller
public class LaundryController {

	@RequestMapping(value = "itemForm")
	public String itemPage() {
		System.out.println("ItemForm");
		return "itemform";
	}
	
	@PostMapping("saveitem")
	public ResponseEntity<Items> addItems(@RequestBody Items item) {
		System.out.println("item");
		System.out.println(item);
//		LaundryitemsValidation liv = new LaundryitemsValidation();
//		WebDataBinder binder = new WebDataBinder(item);
//		binder.setValidator(liv);
//		item = ls.saveitem(item);
//		binder.validate();
//		
//		
//        binder.close();
		return new ResponseEntity<Items>(item, HttpStatus.ACCEPTED);
	}
	
}
