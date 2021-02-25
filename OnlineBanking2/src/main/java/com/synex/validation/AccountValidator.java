package com.synex.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.synex.domain.Account;
import com.synex.service.BranchService;
import com.synex.service.CustomerService;
@Component
public class AccountValidator implements Validator{

	@Autowired
	CustomerService customerService;
	
	@Autowired
	BranchService branchservice;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Account.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Account acc = (Account) target;
		if(customerService.findCustomerByid(acc.getAccountCustomer().getCustomerId()) == null) {
			errors.rejectValue("accountCustomer", "account.accountCustomer.value", "Could not find matching customer");
			
		}
		
		if(branchservice.findBranchByid(acc.getAccountBranch().getBranchId())==null) {
			errors.rejectValue("accountBranch", "account.accountBranch.value", "Could not find matching branch");
		}
		
		
	}

}
