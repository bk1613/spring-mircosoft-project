package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.dao.TransactionDao;
import com.synex.domain.BankTransaction;
import com.synex.repository.BankTransactionRepository;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {

	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	BankTransactionRepository bankTransactionRepository;
	
	@Override
	public List<BankTransaction> findall() {
		// TODO Auto-generated method stub
		return bankTransactionRepository.findAll();
	}

	@Override
	public BankTransaction save(BankTransaction bankTransaction) {
		// TODO Auto-generated method stub
		return transactionDao.save(bankTransaction);
	}

}
