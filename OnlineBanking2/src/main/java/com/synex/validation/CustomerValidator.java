package com.synex.validation;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synex.domain.Customer;
import com.synex.service.UserService;

@Component
public class CustomerValidator implements Validator{

	@Autowired
	UserService userservice;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Customer customer =(Customer)target;
		
		if(customer.getCustomerMoblieNo().length() != 10 || customer.getCustomerPhone().length() !=10) {
			errors.rejectValue("customerMoblieNo", "customer.customerMoblieNo.value", "Moblie must have 10 characters");
			errors.rejectValue("customerPhone", "customer.customerPhone.value", "Phone must have 10 characters");
		}
		
		
		
		if(userservice.findbyid(customer.getUser().getUserId()) == null) {
			errors.rejectValue("user", "customer.user.value", "Customer must have user");
		}
		
		if(customer.getCustomerDob() != null) {
			LocalDate dobDate = customer.getCustomerDob();
			System.out.println("Year: " +  (dobDate.getYear()) + "; month: " + (dobDate.getMonthValue()) + "; day: " + (dobDate.getDayOfMonth()+0));
			LocalDate dobLocalDate = LocalDate.of((dobDate.getYear()), (dobDate.getMonthValue()) , (dobDate.getDayOfMonth()+0));
			LocalDate currentLocalDate = LocalDate.now();
			Period period = Period.between(dobLocalDate, currentLocalDate);
			
			if(period.getYears() < 21) {
				errors.rejectValue("customerDob", "customer.customerDob.value", "Age must be at least 21 years");
			}
			
		}
		if(customer.getCustomerssn().length() != 11) {
			if(customer.getCustomerssn().indexOf("-")==3 && customer.getCustomerssn().indexOf("-",4)==6) {
				errors.rejectValue("customerssn", "customer.customerssn.value", "Give the customer a proper SSN");
			}
		}
		
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName", "customer.customerName.empty", "Customer name must not be empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddess.addressLine1", "customerAddess.addressLine1.empty", "Address Line1 is a required field");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddess.addressLine2", "customerAddess.addressLine2.empty", "Address Line2 is a required field");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddess.city", "customerAddess.city.empty", "City is a required field");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddess.state", "customerAddess.state.empty", "State is a required field");
		
	}
	
}
