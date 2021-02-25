package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.UserAccount;
import com.synex.repo.UserAccountRepo;

@Service
public class UserAccountService {

	@Autowired
	UserAccountRepo userAccRepo;
	
	public UserAccount saveAcc(UserAccount user) {
		
		return userAccRepo.save(user);
	}
	
	public List<UserAccount> findallAccounts(){
		
		return userAccRepo.findAll();
	}
	
	public UserAccount findAcc(String accountNumber) {
		
		return userAccRepo.findByAccountNumber(accountNumber);
	}
	
}
