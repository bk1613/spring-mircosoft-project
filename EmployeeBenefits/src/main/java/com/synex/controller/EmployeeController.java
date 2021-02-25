package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Employee;
import com.synex.service.EmployeeService;

@RestController
public class EmployeeController {
	
	
	@Autowired
	EmployeeService empSer;
	
	@PostMapping("saveEmp")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		System.out.println(emp);
		emp = empSer.saveEmp(emp);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("deductEmp/{id}")
	public ResponseEntity<Employee> deductEmployee(@PathVariable int id){
		
		int ben = 1000/26;
		int dpbenf = 500/26;
		
		Employee emp = empSer.findEmp(id);
		
		int ed = emp.getDependent()*dpbenf;
		int result = emp.getPayment() - ben - ed;
		int pay = 0;
		if(emp.getName().startsWith("A")) {
			System.out.println("pay");
			pay += emp.getPayment()*.1;
			result += pay;
		}
		System.out.println(result);
		emp.setSalary(emp.getSalary()+result);
		//empSer.saveEmp(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("getEmps")
	public ResponseEntity<List<Employee>> getEmployees(){
		
		return new ResponseEntity<List<Employee>>(empSer.getEmployees(), HttpStatus.ACCEPTED);
		
	}

}
