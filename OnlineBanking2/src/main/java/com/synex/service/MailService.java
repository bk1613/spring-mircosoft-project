package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.synex.domain.BankTransaction;

@Service
public class MailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
public SimpleMailMessage sendEmailBTr(BankTransaction btr) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("sfremont2519@gmail.com");
		message.setSubject(btr.getTransactionType() + " transaction " + " has been made");
		message.setText("Your transaction has been made" + "\nThank you\n\nThis is a system generated message.\nPlease don't reply");
		
		javaMailSender.send(message);
		return message;
	}
}
