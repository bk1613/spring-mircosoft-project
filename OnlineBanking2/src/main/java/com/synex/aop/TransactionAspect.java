package com.synex.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.synex.domain.BankTransaction;
import com.synex.service.MailService;

@Aspect // @Aspect makes a class an Aspect that has advices, pointcut Expressions etc.
@Component
public class TransactionAspect {
	
	@Autowired
	MailService mailService;
	
	@After(value="execution( * com.synex.controller.BankTransactionController*.*(..))")
	public void after(JoinPoint joinPoint) {
//		System.out.println("*** @After " + joinPoint.getSignature());
		System.out.println("*** @Afterfind " + joinPoint.getSignature().getName());
	}
	
	@AfterReturning(value="execution( * com.synex.service.BankTransactionServiceImpl*.save(..))", returning="transaction")
	public void afterReturning(JoinPoint jp, BankTransaction transaction) {
		System.out.println("***@AfterReturning " + jp.getSignature().getName());
		System.out.println(transaction);
		SimpleMailMessage message = mailService.sendEmailBTr(transaction);
		String to ="";
		int i = 0;
		
		for(String strEmail : message.getTo()) {
			i++;
			to = to+"<br>"+i+". "+strEmail;
		}
		
		System.out.println("Email has been sent to "+ to);
	}
	
}
