package com.synex.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.synex.model.Employee;


//@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object employeeObject, Errors errors) {
		
		 Employee emp = (Employee) employeeObject;
	        
		 String fullname = emp.getFullName();
	     String mobliephone = "" + emp.getMobileNumber();
	     String email = emp.getEmailId();
	     String dateofbirth = emp.getDateOfBirth();
	     
	     System.out.println(fullname);
//	     ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "field.required","The fullName is a mandatory field");
	     
	     if(fullname == null) {
	    	 errors.rejectValue("fullName", "Employee.fullName","The fullName is a mandatory field");
	     }
	     
	     if(mobliephone == null || mobliephone.length() != 10) {
	        	errors.rejectValue("mobileNumber", "Employee.mobileNumber","The mobileNumber is a mandatory field");
	     }
	        
	      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "field.required", "The emailId is a mandatory field");
	      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "field.required", "The dateOfBirth is a mandatory field");
	        
	      if(email != null && !email.contains("@")) {
	    	  errors.rejectValue("emailId", "Employee.emailId", "The emailId should be in a valid email format");
	      }
	      
	      if(dateofbirth != null && !isValidate(dateofbirth)) {
	        	errors.rejectValue("dateOfBirth", "field.valid","The dateOfBirth should be in YYYY-MM-DD format");
	        }
	        
	     
	}
	
	 public boolean isValidate(String inDate) {
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
	    	try {
	    		dateFormat.parse(inDate.trim());
	    	}catch(ParseException pe) {
	    		return false;
	    	}
	    	return true;
	    }
	    

}
