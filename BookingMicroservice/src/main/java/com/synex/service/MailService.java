package com.synex.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.synex.domain.Booking;

import org.springframework.mail.SimpleMailMessage;

@Service
public class MailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	public SimpleMailMessage sendEmailBookpdf(Booking bk) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("sfremont2519@gmail.com");
		message.setSubject("booking has been made");
		message.setText("Your booking has been made" + "\nThank you\n\nThis is a system generated message.\nPlease don't reply");
		
		javaMailSender.send(message);
		return message;
		
	}
	
	public MimeMessage sendEmailWithAttachment(String to, String pathToAttachment) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setTo(to);
		helper.setSubject("booking has been made");
		helper.setText("Your booking has been made. Please find the attached pdf" + "\nThank you\n\nThis is a system generated message.\nPlease don't reply");
		
		FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
		helper.addAttachment("Booking.pdf", file);
		
		javaMailSender.send(mimeMessage);
		return mimeMessage;
	}
}
