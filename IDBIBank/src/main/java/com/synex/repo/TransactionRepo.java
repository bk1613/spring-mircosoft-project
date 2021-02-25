package com.synex.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

}
