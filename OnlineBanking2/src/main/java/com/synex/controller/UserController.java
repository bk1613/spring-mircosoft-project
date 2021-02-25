package com.synex.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synex.domain.Account;
import com.synex.domain.BankTransaction;
import com.synex.domain.Branch;
import com.synex.domain.Customer;
import com.synex.domain.Role;
import com.synex.domain.TransactionType;
import com.synex.domain.User;
import com.synex.repository.BankTransactionRepository;
import com.synex.service.AccountService;
import com.synex.service.BankTransactionService;
import com.synex.service.BranchService;
import com.synex.service.CustomerService;
import com.synex.service.RoleService;
import com.synex.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userservice;
	
	@Autowired
	RoleService roleservice;
	
	@Autowired
	BranchService branchService;
	
	@Autowired
	AccountService accountService;

	@Autowired
	CustomerService customerService;
	
	@Autowired
	BankTransactionRepository bankTransactionRepository;
	

	@Autowired
	BankTransactionService bankTransactionService;
	
	TransactionType bt;
	
	@RequestMapping("userForm")
	public String UserForm(User user, Model model) {
		List<Role> roles = roleservice.findAll();
		Set<Role> roleSet = new HashSet<>(roles);

		model.addAttribute("roleSet", roleSet);

		model.addAttribute("users", userservice.findAll());
		
		model.addAttribute("user", user);
		return "user";
	}
	
	@PostMapping("saveUser")
	public String saveUser(User user, Model model) {
		userservice.createUser(user);
		List<Role> roles = roleservice.findAll();
		Set<Role> roleSet = new HashSet<>(roles);
		model.addAttribute("roleSet", roleSet);
		model.addAttribute("users", userservice.findAll());
		return "user";
	}
	
	@RequestMapping("updateUser")
	public String updateUser(@RequestParam String userName, User user, Model model) {
		user= userservice.findbyName(userName);
		List<Role> roles = roleservice.findAll();
		Set<Role> roleSet = new HashSet<>(roles);
		model.addAttribute("roleSet", roleSet);
		model.addAttribute("users", userservice.findAll());
		model.addAttribute("user", user);
		return "user";
	}
	
	@RequestMapping("deleteUser")
	public String deleteUser(@RequestParam long userId, User user, Model model) {
		userservice.delete(userId);
		List<Role> roles = roleservice.findAll();
		Set<Role> roleSet = new HashSet<>(roles);
		model.addAttribute("roleSet", roleSet);
		model.addAttribute("users", userservice.findAll());
		return "user";
	}
	
	@GetMapping("login")
	public String login(
			@RequestParam(value="logout", required=false) String logout,
			@RequestParam(value="error", required=false) String error,
			HttpServletRequest request, HttpServletResponse response,
			Model model
			) {
		String message = null;
		if(error != null) {
			message = "Your login credientials are not OK.";
		}
		
		if(logout != null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(authentication != null) {
				new SecurityContextLogoutHandler().logout(request, response, authentication);
			}
			message ="You have been Logged out successfully.";
			model.addAttribute("message", message);
			return "login";
		}
		
		return "login";//view name
		
	}
	@RequestMapping(value="/accessDenied", method= RequestMethod.GET)
	public String denyAccess() {
		return "accessDenied";
	}
	

	@GetMapping("/home")
	public String welcome(Customer customer, Account account, Branch branch, Model model, Principal principal, User user) {
		
		System.out.println("Name: " + principal);
		if(principal == null) {
			return "login";
		}else {
			user = userservice.findbyName(principal.getName());
			customer = customerService.findCustomerbyUserId(user.getUserId());
			List<Account> acc = accountService.findAccountByCustomerId(customer.getCustomerId());
			
			
			List<BankTransaction> btl = bankTransactionService.findall();
			//System.out.println(btl);
			model.addAttribute("balances", acc);
			model.addAttribute("ssn", customer.getCustomerssn());
//			
			List<BankTransaction> newbtl = new ArrayList<>();
			for(var a: acc) {
				account = a;
				for(BankTransaction b: btl) {
					//newbtl.add(b);
					if(b.getBankTransactionFromAccount() != null && b.getBankTransactionToAccount() != null) {
						
						if(b.getBankTransactionFromAccount() == account.getAccountId() || b.getBankTransactionToAccount() == account.getAccountId()) {
							//System.out.println(b.getBankTransactionFromAccount()+ " "+b.getBankTransactionToAccount());
							newbtl.add(new BankTransaction(b.getBankTransactionToAccount(), b.getBankTransactionAmount(), b.getTransactionType(), b.getBankTransactionDateTime()));
						}
						
					}else if (b.getBankTransactionFromAccount() != null && b.getBankTransactionToAccount() == null) {
						if(b.getBankTransactionFromAccount() == account.getAccountId()) 
								newbtl.add(new BankTransaction(b.getBankTransactionAmount(), b.getTransactionType(), b.getBankTransactionDateTime()));
						
					}else if (b.getBankTransactionToAccount() != null && b.getBankTransactionFromAccount() == null) {
						if(b.getBankTransactionToAccount() == account.getAccountId())
							newbtl.add(new BankTransaction(b.getBankTransactionAmount(), b.getTransactionType(), b.getBankTransactionDateTime()));
						
					}	
				}

			}
			Comparator<BankTransaction> btdatecomparator = (BankTransaction btr1, BankTransaction btr2) -> btr2.getBankTransactionDateTime().compareTo(btr1.getBankTransactionDateTime());
			newbtl.sort(btdatecomparator);
			for(BankTransaction b: newbtl) {
				System.out.println(b.getBankTransactionToAccount() + " " + b.getBankTransactionDateTime() + " " + b.getTransactionType());
			}
			model.addAttribute("history", newbtl);
			return "welcome";
		}
	}
}
