package com.synex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.LeaveRequest;
import com.synex.repository.RequestRepository;

@Service
public class RegLeaveService {

	@Autowired
	RequestRepository reqRep;
	
	public LeaveRequest saveRequest(LeaveRequest req) {
		return reqRep.save(req);
	}
	
	public LeaveRequest findRequestbyid(int id) {
		Optional<LeaveRequest> reqop = reqRep.findById(id);
		if(reqop.get() == null)
			return null;
		else
			return reqop.get();
	}
	
	public LeaveRequest findrequestbyEmpid(int id) {
		return reqRep.findByEmpId(id);
	}
	
}
