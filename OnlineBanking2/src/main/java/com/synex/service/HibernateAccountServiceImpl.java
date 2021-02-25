package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.dao.AccountDao;
import com.synex.domain.Account;

@Service(value="HibernateAccountService")
public class HibernateAccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountdao;
	
	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountdao.findAll();
	}

	@Override
	public Account findAccountByid(Long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccountById(Long accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> findAccountByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
