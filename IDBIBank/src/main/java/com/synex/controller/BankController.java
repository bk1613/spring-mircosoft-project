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

import com.synex.domain.InsufficientFunds;
import com.synex.domain.Message;
import com.synex.domain.Transaction;
import com.synex.domain.UserAccount;
import com.synex.service.TransactionService;
import com.synex.service.UserAccountService;

@RestController
public class BankController {
	
	@Autowired
	UserAccountService userSer;
	
	@Autowired
	TransactionService tranSer;
	
	@PostMapping("addAccount")
	public ResponseEntity<UserAccount> addAccount(@RequestBody UserAccount user){
		
		System.out.println("save");
		
		user = userSer.saveAcc(user);
		
		return new ResponseEntity<UserAccount>(user, HttpStatus.CREATED);
		
	}

	@GetMapping("findAllAccount")
	public ResponseEntity<List<UserAccount>> findAllAccounts(){
		
		
		
		List<UserAccount> users = userSer.findallAccounts();
		
		return new ResponseEntity<List<UserAccount>>(users, HttpStatus.FOUND);
		
	}
	
	@GetMapping("findAllTsransaction")
	public ResponseEntity<List<Transaction>> findAllTransaction(){
		
		
		
		List<Transaction> trans = tranSer.findallTrans();
		
		return new ResponseEntity<List<Transaction>>(trans, HttpStatus.FOUND);
		
	}
	
	@GetMapping("findbyAccountNum/{AccNum}")
	public ResponseEntity<UserAccount> findAccount(@PathVariable String AccNum){
		
		System.out.println("save");
		
		UserAccount user = userSer.findAcc(AccNum);
		
		return new ResponseEntity<UserAccount>(user, HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("makeTrans")
	public ResponseEntity<?> makeTransaction(@RequestBody Transaction tran){
		
		UserAccount from = userSer.findAcc(tran.getFromAccount());
		UserAccount to = userSer.findAcc(tran.getToAccount());
		
		
		
		
		Message meg = new Message();
		if(from.getBalance() < tran.getAmount()) {
			
			
			InsufficientFunds Inmeg = new InsufficientFunds("Insufficient Funds", from.getBalance());
			
			return new ResponseEntity<InsufficientFunds>(Inmeg, HttpStatus.BAD_REQUEST);
		}else {
			meg.setStatus("Success");
			meg.setBalance(from.getBalance());
			
			from.setBalance(from.getBalance()-tran.getAmount());
			to.setBalance(to.getBalance()+tran.getAmount());
			
			userSer.saveAcc(from);
			userSer.saveAcc(to);
			tran.setStatus("Success");
			tranSer.saveTrans(tran);
			
			return new ResponseEntity<Message>(meg, HttpStatus.ACCEPTED);
		}
		
		
	}
	
}
