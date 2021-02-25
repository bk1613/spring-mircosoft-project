package com.synex.service;

import java.util.List;

import com.synex.domain.Customer;;

public interface CustomerService {
	public Customer save(Customer customer);
	
	public List<Customer> findAll();
	
	public Customer findCustomerByid(Long customerId);
	
	public Customer findByName(String name);
	
	public void deleteCustomerById(Long customerId);
	
	public Customer findCustomerbyUserId(long id);
	
}
