package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.LeaveRequest;

public interface RequestRepository extends JpaRepository<LeaveRequest, Integer> {

	public LeaveRequest findByEmpId(int id);
	
}

