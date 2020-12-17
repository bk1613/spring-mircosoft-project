package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.synex.model.Person;
import com.synex.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	ContactService service;
	
	@PostMapping(value = "/contact/save", produces="application/json")
	public ResponseEntity<Person> savePerson(@RequestBody Person per){
		System.out.println(per);
		Person p = service.save(per);
		return new ResponseEntity<Person>(p, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "contact/retieve/{id}", produces="application/json")
	public ResponseEntity<Person> getPerson(@PathVariable int id){
		System.out.println(id);
		Person p = service.get(id);
		System.out.println(p);
		return new ResponseEntity<Person>(p, HttpStatus.OK);
	}
}
