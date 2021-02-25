package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.synex.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public Customer findByCustomerName(String name);
	
	@Transactional//to acoid, javax.persistence.TransactionRequiredException: Excuting an update/delete query
	@Modifying
	@Query("delete from Customer c where c.customerId=:customerId")//HQL or JPA QL being used here.
	public void deleteCustomerById(@Param("customerId") long customerId);
	
	@Query(value="select c from Customer c where c.user.userId=:userId")
	public Customer findCustomerByUserId(@Param("userId") long userId);
}
