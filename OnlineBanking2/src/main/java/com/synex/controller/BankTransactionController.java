package com.synex.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synex.domain.Account;
import com.synex.domain.BankTransaction;
import com.synex.domain.TransactionType;
import com.synex.repository.BankTransactionRepository;
import com.synex.service.AccountService;
import com.synex.service.BankTransactionService;

@Controller
public class BankTransactionController {

	@Autowired
	BankTransactionRepository bankTransactionRepository;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	BankTransactionService bankTransactionService;
	
	TransactionType bt;
	
	@RequestMapping("transfertransaction")
	public String getTransTransaction(BankTransaction bankTransaction, Model model){
		bankTransaction.setTransactionType(bt.TRANSFER);
		bankTransaction.setBankTransactionDateTime(LocalDateTime.now());
		model.addAttribute("banktransactions", bankTransactionRepository.findAll());
		return "transferbanktransaction";
	}
	
	@RequestMapping("deposittransaction")
	public String getDepositTransaction(BankTransaction bankTransaction, Model model){
		System.out.println("Deposit");
		bankTransaction.setTransactionType(bt.DEPOSIT);
		System.out.println(bankTransaction.getTransactionType());
		bankTransaction.setBankTransactionDateTime(LocalDateTime.now());
		bankTransactionService.findall();
		List<BankTransaction> btra = bankTransactionRepository.findAll();
		model.addAttribute("banktransactions", btra);
		return "depositbanktransaction";
	}
	
	@RequestMapping("withdrawaltransaction")
	public String getWithdrawalTransaction(BankTransaction bankTransaction, Model model){
		bankTransaction.setTransactionType(bt.WITHDRAWAL);
		bankTransaction.setBankTransactionDateTime(LocalDateTime.now());
		model.addAttribute("banktransactions", bankTransactionRepository.findAll());
		return "withdrawalbanktransaction";
	}
	
	@PreAuthorize(value = "hasAuthority('User') || hasAuthority('Manager')")
	@RequestMapping("hometransaction")
	public String getNewAccTransaction(BankTransaction bankTransaction, Model model){
		model.addAttribute("banktransactions", bankTransactionRepository.findAll());
		return "newacctransferbanktransaction";
	}
	
	@RequestMapping("makeTranaction")
	public String makeBankTransaction(BankTransaction bankTransaction, Model model){
		System.out.println("banktrans");
		System.out.println(bankTransaction.getTransactionType());
		System.out.println(bankTransaction.getBankTransactionDateTime());
		double acc = bankTransaction.getBankTransactionAmount();
		
		if(bankTransaction.getTransactionType() == bt.TRANSFER) {
			Account accountto = accountService.findAccountByid(bankTransaction.getBankTransactionToAccount());
			Account accountfrom = accountService.findAccountByid(bankTransaction.getBankTransactionFromAccount());
			accountfrom.setAccountBalance(accountfrom.getAccountBalance()-acc);
			accountto.setAccountBalance(accountto.getAccountBalance()+acc);
			accountService.save(accountto);
			accountService.save(accountfrom);
			bankTransactionService.save(bankTransaction);
			model.addAttribute("banktransactions", bankTransactionRepository.findAll());
			return "transferbanktransaction";
			
		}else if(bankTransaction.getTransactionType() == bt.DEPOSIT) {
			
			Account accountto = accountService.findAccountByid(bankTransaction.getBankTransactionToAccount());
			System.out.println(accountto.getAccountBalance());
			accountto.setAccountBalance(accountto.getAccountBalance()+acc);
			System.out.println(accountto.getAccountBalance());
			accountService.save(accountto);
			bankTransactionService.save(bankTransaction);
			model.addAttribute("banktransactions", bankTransactionRepository.findAll());
			return "depositbanktransaction";
			
		}else{
			Account accountfrom = accountService.findAccountByid(bankTransaction.getBankTransactionFromAccount());
			accountfrom.setAccountBalance(accountfrom.getAccountBalance()-acc);
			accountService.save(accountfrom);
			bankTransactionService.save(bankTransaction);
			model.addAttribute("banktransactions", bankTransactionRepository.findAll());
			return "withdrawalbanktransaction";
			
		}
	}
	
	@RequestMapping("movetotransactions")
	public String Transactions(BankTransaction bankTransaction, Account account, Model model){
		if(bankTransaction.getTransactionType() == bt.TRANSFER) {
			bankTransaction.setBankTransactionDateTime(LocalDateTime.now());
			model.addAttribute("banktransactions", bankTransactionRepository.findAll());
			return "transferbanktransaction";
			
		}else if(bankTransaction.getTransactionType() == bt.DEPOSIT) {
			bankTransaction.setBankTransactionDateTime(LocalDateTime.now());
			model.addAttribute("banktransactions", bankTransactionRepository.findAll());
			return "depositbanktransaction";
			
		}else if(bankTransaction.getTransactionType() == bt.WITHDRAWAL){
			bankTransaction.setBankTransactionDateTime(LocalDateTime.now());
			model.addAttribute("banktransactions", bankTransactionRepository.findAll());
			return "withdrawalbanktransaction";
		}else {
			model.addAttribute("accounts", accountService.findAll());
			return "accountform";
		}
	}
}
