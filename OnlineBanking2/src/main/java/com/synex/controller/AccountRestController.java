package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Account;
import com.synex.service.AccountService;

@RestController
public class AccountRestController {

	@Autowired
	@Qualifier("HibernateAccountService")
	AccountService accountService;
	
	@GetMapping(value="getAllAccountsApi", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> findallAccount(){
		//use session factory to create account
		List<Account> accounts = accountService.findAll();
		System.out.println("accounts");
		
		if(accounts.isEmpty()) {
			return new ResponseEntity<List<Account>>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Account>>(accounts, HttpStatus.FOUND);
		}
	}
	
	@GetMapping(value="getApiAccount", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> findAccount(@RequestParam long id){
		System.out.println("getAPiForm");
		Account account = accountService.findAccountByid(id);
		if(account == null) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Account>(account, HttpStatus.FOUND);
		}
		
	}
	
}
