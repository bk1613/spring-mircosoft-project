package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.LeaveApproval;
import com.synex.repository.ApprovalRepository;

@Service
public class AppLeaveService {

	@Autowired
	ApprovalRepository appRep;
	
	public LeaveApproval saveApproval(LeaveApproval app) {
		return appRep.save(app);
		
	}
	
}
