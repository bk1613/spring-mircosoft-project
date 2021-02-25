package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.repository.ItemRepository;
//import com.synex.repository.OrderRepository;
import com.synex.repository.RequestRepository;

@Service
public class LaundryService {

	@Autowired
	ItemRepository itemrepo;
	
	@Autowired
	RequestRepository reqRepo;
	
//	@Autowired
//	OrderRepository orderRepo;
	
	
}
