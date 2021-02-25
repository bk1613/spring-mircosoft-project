package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.InitBinder;

import com.synex.model.Employee;
import com.synex.service.EmployeeService;
import com.synex.validation.EmployeeValidator;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empser;
	
//	@Autowired
//	EmployeeValidator empvalidator;
//	
//	@InitBinder
//	public void InitBinder(WebDataBinder binder) {
//		binder.addValidators(empvalidator);
//	}
	
	@PostMapping("employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) throws BindException{
		
		EmployeeValidator validator = new EmployeeValidator();

        WebDataBinder binder = new WebDataBinder(emp);
        binder.setValidator(validator);

        binder.validate();
        binder.close();
	
			//emp = empser.save(emp);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}

}
