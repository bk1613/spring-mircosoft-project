package com.synex.controller;

import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.domain.LeaveApproval;
import com.synex.domain.LeaveBalance;
import com.synex.domain.LeaveRequest;
import com.synex.domain.Status;
import com.synex.service.AppLeaveService;
import com.synex.service.BalLeaveService;
import com.synex.service.RegLeaveService;
import com.synex.validation.RequestValidation;

@Controller
public class LeaveController {

	@Autowired
	BalLeaveService balSer;
	
	@Autowired
	AppLeaveService appSer;
	
	@Autowired
	RegLeaveService reqSer;
	
	@PostMapping("addbalance")
	public ResponseEntity<LeaveBalance> addBalance(@RequestBody LeaveBalance balance){
		balance = balSer.savebalance(balance);
		return new ResponseEntity<LeaveBalance>(balance, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("addrequest")
	public ResponseEntity<LeaveRequest> addRequest(@RequestBody LeaveRequest request) throws BindException{
		LeaveBalance balance = balSer.findbalancebyEmpid(request.getEmpId());
		//LeaveRequest alreayrequest = reqSer.findrequestbyEmpid(request.getEmpId());
		if(balance != null) {
			RequestValidation validator = new RequestValidation();
			validator.setBala(balance);
			//validator.setRequ(alreayrequest);
			WebDataBinder binder = new WebDataBinder(request);
	        binder.setValidator(validator);
	        binder.validate();
	        binder.close();
		
		
		
		
		
		
			
			request = reqSer.saveRequest(request);
			
		}
		
		return new ResponseEntity<LeaveRequest>(request, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("addapproval")
	public ResponseEntity<LeaveApproval> addApproval(@RequestBody LeaveApproval app){
		
		app.setStatus(Status.APPROVED);
		LeaveRequest req = reqSer.findRequestbyid(app.getReqid());
		req.setStatus(Status.APPROVED);
		app.setLeaveRequestId(req);
		app = appSer.saveApproval(app);
		return new ResponseEntity<LeaveApproval>(app, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("findBal/{id}")
	public ResponseEntity<LeaveBalance> addApproval(@PathVariable int id){
		System.out.println("find");
		LeaveBalance bal = balSer.findbalancebyEmpid(id);
		System.out.println(bal);
		return new ResponseEntity<LeaveBalance>(bal, HttpStatus.ACCEPTED);
	}
}
