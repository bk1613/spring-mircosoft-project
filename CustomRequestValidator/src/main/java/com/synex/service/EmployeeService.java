package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.model.Employee;
import com.synex.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository emprepo;
	
	public Employee save(Employee emp) {
		return emprepo.save(emp);
	}
	
}
