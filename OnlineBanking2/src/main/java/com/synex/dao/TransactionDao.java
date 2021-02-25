package com.synex.dao;

import com.synex.domain.BankTransaction;

public interface TransactionDao {
	public BankTransaction findall();
	public BankTransaction save(BankTransaction bankTransaction);
	public BankTransaction findById (long id);
}
