package com.synex.validation;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synex.domain.LeaveBalance;
import com.synex.domain.LeaveRequest;
import com.synex.service.BalLeaveService;
import com.synex.service.RegLeaveService;

@Component
public class RequestValidation implements Validator {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	BalLeaveService bal;
	
	@Autowired
	RegLeaveService reqSer;
	
	LeaveBalance bala;
	
	LeaveRequest requ;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return LeaveRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		LeaveRequest req = (LeaveRequest) target;
		
		LocalDate fromDate = req.getFromDate();
		LocalDate toDate = req.getToDate();
		int empid = req.getEmpId();
		
		System.out.println(empid);
		System.out.println(bala);
		Period period = Period.between(fromDate, toDate);
		int diff = Math.abs(period.getDays());
		
		System.out.println(diff < bala.getBalance());
		if(diff < bala.getBalance()) {
			errors.rejectValue("toDate", "field.valid", "The balance has not reached its mark");;
		}
		
//		if(requ ) {
//			errors.rejectValue("empId", "field.valid", "a leave requst is already made for empid");
//		}
		
	}

	public LeaveBalance getBala() {
		return bala;
	}

	public void setBala(LeaveBalance bala) {
		this.bala = bala;
	}

	public LeaveRequest getRequ() {
		return requ;
	}

	public void setRequ(LeaveRequest requ) {
		this.requ = requ;
	}

	
	
}
