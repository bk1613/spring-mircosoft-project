package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Employee;
import com.synex.repository.EmployeeRepositoy;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepositoy empRepo;
	
	public Employee saveEmp(Employee emp) {
		
		return empRepo.save(emp);
		
	}

	public Employee findEmp(int id) {
		Optional<Employee> empop = empRepo.findById(id);
		if(empop.get() == null) {
			return null;
		}else {
			return empop.get();
		}
	}
	
	public List<Employee> getEmployees(){
		return empRepo.findAll();
	}
	
}
