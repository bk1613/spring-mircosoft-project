package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.LeaveBalance;
import com.synex.repository.BalanceRepository;

@Service
public class BalLeaveService {

	@Autowired
	BalanceRepository balRep;
	
	public LeaveBalance savebalance(LeaveBalance bal) {
		return balRep.save(bal);
	}
	
	public LeaveBalance findbalancebyEmpid(int id) {
		return balRep.findByEmpId(id);
	}
	
}
