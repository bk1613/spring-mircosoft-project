package com.synex.service;

import java.util.List;

import com.synex.domain.BankTransaction;

public interface BankTransactionService {
	public List<BankTransaction> findall();
	
	public BankTransaction save(BankTransaction bankTransaction);
}
