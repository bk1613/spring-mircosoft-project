package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.synex.domain.Account;
import com.synex.domain.Customer;

public interface AccountRepository extends JpaRepository<Account, Long> {
	@Transactional//to acoid, javax.persistence.TransactionRequiredException: Excuting an update/delete query
	@Modifying
	@Query("delete from Account a where a.accountId=:accountId")//HQL or JPA QL being used here.
	public void deleteAccountById(@Param("accountId") long accountId);
	
	@Query(value="select a from Account a where a.accountCustomer.customerId=:customerId")
	public List<Account> findAccountByCustomerId(@Param("customerId") long customerId);
}
