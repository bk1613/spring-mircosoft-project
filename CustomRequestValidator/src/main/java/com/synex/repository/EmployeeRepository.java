package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
