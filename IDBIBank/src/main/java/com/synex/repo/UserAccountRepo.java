package com.synex.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.UserAccount;

public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {
	
	public UserAccount findByAccountNumber(String accountNumber);
}
