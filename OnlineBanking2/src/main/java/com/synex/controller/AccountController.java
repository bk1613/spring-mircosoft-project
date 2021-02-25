package com.synex.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synex.domain.Account;
import com.synex.domain.Branch;
import com.synex.domain.Customer;
import com.synex.service.AccountService;
import com.synex.service.BranchService;
import com.synex.service.CustomerService;
import com.synex.validation.AccountValidator;

@Controller
public class AccountController {
	
	@Autowired
	@Qualifier("JPCAccountService")
	AccountService accountService;

	@Autowired
	CustomerService customerService;
	
	@Autowired
	BranchService branchservice;
	
	@Autowired
	AccountValidator accountvalidator;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(accountvalidator);
		
	}
	@PreAuthorize(value = "hasAuthority('User') || hasAuthority('Manager')")
	@RequestMapping("accountform")
	public String getAccountForm(Account account, Model model) {
		model.addAttribute("accounts", accountService.findAll());
		return "accountform";
	}
	
	@RequestMapping("saveAccount")
	public String saveAccount(@Valid @ModelAttribute Account account, BindingResult br, Model model) {
		Customer cust = customerService.findCustomerByid(account.getAccountCustomer().getCustomerId());
		Branch branch = branchservice.findBranchByid(account.getAccountBranch().getBranchId());
		if(!br.hasErrors()) {
			account.setAccountBranch(branch);
			account.setAccountCustomer(cust);
			account = accountService.save(account);
			model.addAttribute("account", account);
			model.addAttribute("accounts", accountService.findAll());
		}
		
		return "accountform";
	}
	
	@RequestMapping("updateAccount")
	public String updateAccount(@RequestParam long id, Account account, Model model) {
		
		account = accountService.findAccountByid(id);
		model.addAttribute("account", account);
		model.addAttribute("accounts", accountService.findAll());
		
		
		return "accountform";
	}
	
	@RequestMapping("deleteAccount")
	public String deleteAccount(@RequestParam long id, Account account, Model model) {
		
		accountService.deleteAccountById(id);
		model.addAttribute("account", account);
		model.addAttribute("accounts", accountService.findAll());
		
		
		return "accountform";
	}
	
	
}
