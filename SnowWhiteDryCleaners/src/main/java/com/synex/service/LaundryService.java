package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Laundryitems;
import com.synex.repository.LaundryItemsRepository;
import com.synex.repository.LaundryRequestsRepository;

@Service
public class LaundryService {
	
	@Autowired
	LaundryItemsRepository litrepo;
	
	@Autowired
	LaundryRequestsRepository lreqrepo;
	
	public Laundryitems saveitem(Laundryitems item) {
		
		return litrepo.save(item);
	}
	
	public Laundryitems saverequest(Laundryitems item) {
		
		return litrepo.save(item);
	}
	
	
	public Laundryitems findItem() {
		return null;
	}
	
	public void deleteitems() {
		litrepo.deleteAll();
	}
	
}
