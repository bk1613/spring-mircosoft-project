package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.LeaveBalance;

public interface BalanceRepository extends JpaRepository<LeaveBalance, Integer> {

	public LeaveBalance findByEmpId(int id);
}
