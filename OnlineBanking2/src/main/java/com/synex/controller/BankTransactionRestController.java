package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.BankTransaction;
import com.synex.service.BankTransactionService;

@RestController
public class BankTransactionRestController {
	
	@Autowired
	BankTransactionService bankTransactionservice;
	
	@GetMapping(value="getAllBankTranactionsApi", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BankTransaction>> getHistoryofTransaction(){
		List<BankTransaction> btrList = bankTransactionservice.findall();
		
		if(btrList.isEmpty()) {
			return new ResponseEntity<List<BankTransaction>>(btrList, HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<BankTransaction>>(btrList, HttpStatus.FOUND);
		}
		
		
	}
	
}
