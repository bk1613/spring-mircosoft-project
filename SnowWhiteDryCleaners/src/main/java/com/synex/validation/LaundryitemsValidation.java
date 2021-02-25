package com.synex.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.synex.domain.Laundryitems;


public class LaundryitemsValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Laundryitems.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
