package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synex.domain.Account;
import com.synex.repository.AccountRepository;

@Service(value="JPCAccountService")
@Primary
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account findAccountByid(Long accountId) {
		// TODO Auto-generated method stub
		Optional<Account> optEmployee = accountRepository.findById(accountId);
		if(optEmployee.isPresent()) {
		return optEmployee.get();
		}else {
			System.out.println("Branch id " + accountId + " does not exist.");
			return null;
		}
	}

	@Override
	public Account findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccountById(Long accountId) {
		// TODO Auto-generated method stub
		accountRepository.deleteAccountById(accountId);
	}

	@Override
	public List<Account> findAccountByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return accountRepository.findAccountByCustomerId(customerId);
	}

}
