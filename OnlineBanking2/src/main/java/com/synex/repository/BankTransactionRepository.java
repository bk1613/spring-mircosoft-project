package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.BankTransaction;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long> {
	// use this repository for find/get/display purpose only. Don't use for save/update/delete.
	// you can use security features
}
