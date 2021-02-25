package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Employee;

public interface EmployeeRepositoy extends JpaRepository<Employee, Integer> {

}
