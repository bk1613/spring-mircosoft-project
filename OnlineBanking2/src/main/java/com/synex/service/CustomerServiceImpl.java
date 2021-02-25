package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Customer;
import com.synex.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomerByid(Long customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> optcustomer = customerRepository.findById(customerId);
		if(optcustomer.isPresent()) {
		return optcustomer.get();
		}else {
			System.out.println("Role id " + customerId + " does not exist.");
			return null;
		}
	}

	@Override
	public Customer findByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerName(name);
	
	}

	@Override
	public void deleteCustomerById(Long customerId) {
		customerRepository.deleteCustomerById(customerId);
		
	}

	@Override
	public Customer findCustomerbyUserId(long userId) {
		// TODO Auto-generated method stub
		return customerRepository.findCustomerByUserId(userId);
	}

}
