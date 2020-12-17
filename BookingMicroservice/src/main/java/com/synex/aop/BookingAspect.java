package com.synex.aop;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.synex.domain.Booking;
import com.synex.domain.Guest;
import com.synex.service.MailService;

@Aspect // @Aspect makes a class an Aspect that has advices, pointcut Expressions etc.
@Component
public class BookingAspect {

	@Autowired
	MailService mailService;
	
	@AfterReturning(value="execution( * com.synex.service.BookingServiceImpl*.save(..))", returning="book")
	public void afterReturning(JoinPoint jp, Booking book) throws DocumentException, MessagingException, MalformedURLException, IOException {
		System.out.println("***@AfterReturning " + jp.getSignature().getName());
		System.out.println(book);

		Document pdfDoc = new Document();
		PdfWriter.getInstance(pdfDoc, new FileOutputStream("Booking_id_"+book.getBookingId()+".pdf"));
		
		pdfDoc.open();
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Font subtitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
		Font title = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.DARK_GRAY);
		
		Paragraph ttl = new Paragraph("Thank you for Registering " + book.getUserName(), title);
		ttl.setSpacingAfter(10f);
		pdfDoc.add(ttl);
		
		Paragraph hotelInfo = new Paragraph("Hotel Address:", subtitle);
		pdfDoc.add(hotelInfo);
		Paragraph hotelNm = new Paragraph(book.getHotelName()+",", font);
		Paragraph hotelAddr = new Paragraph(book.getAddress()+",", font);
		Paragraph hotelCt = new Paragraph(book.getCity()+",", font);
		Paragraph hotelStt = new Paragraph(book.getState()+"", font);
		
		hotelStt.setSpacingAfter(10f);

		pdfDoc.add(hotelNm);
		pdfDoc.add(hotelAddr);
		pdfDoc.add(hotelCt);
		pdfDoc.add(hotelStt);
		
		Image image = Image.getInstance(new URL(book.getImageURL()));
		image.scaleAbsolute(530f, 310f);
		image.setSpacingAfter(10f);
		pdfDoc.add(image);
		
		List<Paragraph> chunks = new ArrayList<>();
		
		chunks.add(new Paragraph("Booking id: " + book.getBookingId(), font));
		chunks.add(new Paragraph("Hotel id: " + book.getHotelId(), font));
		chunks.add(new Paragraph("Hotel name: " + book.getHotelName(), font));
		chunks.add(new Paragraph("Room Id : " + book.getHotelRoomId(), font));
		chunks.add(new Paragraph("These are the No. of rooms you asked for " + book.getNoRooms(), font));
		chunks.add(new Paragraph("Checkin date: " + book.getCheckInDate(), font));
		chunks.add(new Paragraph("Checkout date: " + book.getCheckOutDate(), font));
		chunks.add(new Paragraph("Booked on " + book.getBookedOnDate(), font));
		chunks.add(new Paragraph("Roomtype: " + book.getRoomType(), font));
		chunks.add(new Paragraph("This is your phone number: " + book.getCustomerMobile(), font));
		chunks.add(new Paragraph("total price: " + book.getPrice(), font));
		chunks.add(new Paragraph("discount: " + book.getDiscount(), font));
		chunks.add(new Paragraph("Guests: " + book.getGuests().size(), font));
		
		chunks.add(new Paragraph("-----------------------------------------------", font));
		
		for(Guest guest: book.getGuests()) {
			chunks.add(new Paragraph("First Name: " + guest.getFirstName(), font));
			chunks.add(new Paragraph("Last Name: " + guest.getLastName(), font));
			chunks.add(new Paragraph("Gender: " + guest.getGender(), font));
			chunks.add(new Paragraph("Age: " + guest.getAge(), font));
			chunks.add(new Paragraph("--------------------------------------------", font));
		}
		
		for(Paragraph p : chunks) {
			pdfDoc.add(p);            
        }
		
		pdfDoc.close();
		
		
		
		MimeMessage message = mailService.sendEmailWithAttachment(book.getEmail(),"Booking_id_"+book.getBookingId()+".pdf");
		
		
		System.out.println("email has been sent");
		
	}
}
