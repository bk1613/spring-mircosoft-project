package com.synex.dao;

import java.util.List;

import com.synex.domain.Account;

public interface AccountDao {
public Account save(Account account);
	
	public List<Account> findAll();
	
	public Account findAccountByid(Long accountId);
	
	public Account findByName(String name);
	
	public void deleteAccountById(Long accountId);
	
	public Account findAccountByCustomerId(Long customerId);
}
