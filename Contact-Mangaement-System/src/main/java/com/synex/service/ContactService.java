package com.synex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.model.Person;
import com.synex.repostory.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	ContactRepository rep;
	
	public Person save(Person p) {
		
		return rep.save(p);
		
	}
	
	public Person get(int id) {
		Optional<Person> per = rep.findById(id);
		return per.get();
	}

}
