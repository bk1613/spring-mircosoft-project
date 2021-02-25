package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Transaction;
import com.synex.repo.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	TransactionRepo traRepo;
	
	public Transaction saveTrans(Transaction tra) {
		
		return traRepo.save(tra);
	}
	
	
	public List<Transaction> findallTrans() {
		
		return traRepo.findAll();
	}
}
