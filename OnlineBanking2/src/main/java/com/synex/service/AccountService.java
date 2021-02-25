package com.synex.service;

import java.util.List;

import com.synex.domain.Account;

public interface AccountService {
	public Account save(Account account);
	
	public List<Account> findAll();
	
	public Account findAccountByid(Long accountId);
	
	public Account findByName(String name);
	
	public void deleteAccountById(Long accountId);
	
	public List<Account> findAccountByCustomerId(Long customerId);
}
