package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synex.domain.Laundryitems;
import com.synex.service.LaundryService;
import com.synex.validation.LaundryitemsValidation;

@Controller
public class LaundryController {
	
	@Autowired
	LaundryService ls;
	
//	@Autowired
//	LaundryitemsValidation liv;
	
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String itempage() {
		
		return "ItemForm";
	}
	
	@PostMapping("saveitem")
	public ResponseEntity<Laundryitems> addItems(@ModelAttribute Laundryitems item) throws BindException {
		System.out.println("item");
		LaundryitemsValidation liv = new LaundryitemsValidation();
		WebDataBinder binder = new WebDataBinder(item);
		binder.setValidator(liv);
		item = ls.saveitem(item);
		binder.validate();
		
		
        binder.close();
		return new ResponseEntity<Laundryitems>(item, HttpStatus.ACCEPTED);
	}
	
	
}
