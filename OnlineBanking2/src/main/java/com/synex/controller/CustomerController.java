package com.synex.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synex.domain.Customer;
import com.synex.domain.User;
import com.synex.service.CustomerService;
import com.synex.service.UserService;
import com.synex.validation.CustomerValidator;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	CustomerValidator customerValidator;
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(customerValidator);
		
	}
	@PreAuthorize(value = "hasAuthority('User') || hasAuthority('Manager')")
	@RequestMapping("customerform")
	public String getCusterForm(Customer customer, Model model) {
		model.addAttribute("customers", customerService.findAll());
		return "customerform";
	}
	
	@RequestMapping("saveCustomer")
	public String saveCuster(@Valid @ModelAttribute Customer customer, BindingResult br, Model model) {
		User user = userservice.findbyid(customer.getUser().getUserId());
		
		
		if(!br.hasErrors()) {
			System.out.println(user);
			customer.setUser(user);
			customer = customerService.save(customer);
			model.addAttribute("customer", customer);
			model.addAttribute("customers", customerService.findAll());
		}
		return "customerform";
		
	}
	@RequestMapping("updateCustomer")
	public String updateCustomer(@RequestParam long id, Customer customer, Model model) {
		customer = customerService.findCustomerByid(id);
		model.addAttribute("customer", customer);
		model.addAttribute("customers", customerService.findAll());
		return "customerform";
	}
	
	@RequestMapping("deleteCustomer")
	public String dleteCustomer(@RequestParam long id, Customer customer, Model model) {
		customerService.deleteCustomerById(id);
		model.addAttribute("customer", customer);
		model.addAttribute("customers", customerService.findAll());
		return "customerform";
	}
	
}
