package com.synex.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Booking;
import com.synex.domain.Guest;
import com.synex.domain.RoomInventory;
import com.synex.service.BookingService;
import com.synex.service.GuestService;

@CrossOrigin
@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@Autowired
	GuestService guestService;
	
	@RequestMapping(value = "/bookhotel", method = RequestMethod.POST)
	public ResponseEntity<Booking> bookHotel(@RequestBody Booking book){
		
		book.setStatus("booked");
		Booking ro = bookingService.save(book);
		
		
		return new ResponseEntity<Booking>(ro, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/booklist", method = RequestMethod.POST)
	public ResponseEntity<List<Booking>> getbookingbyuser(@RequestBody String user){
		System.out.println("In Microservice........."+user);
		JSONObject jsonbook=new JSONObject(user);
		
		
		
		List<Booking> bkdatelist = bookingService.findbyuser(jsonbook.getString("userName"));
//		
		for(var b: bkdatelist) {
			System.out.println(b);
		}
		
		return new ResponseEntity<List<Booking>>(bkdatelist, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/bookGuest", method = RequestMethod.POST)
	public ResponseEntity<List<RoomInventory>> bookingcheckdate(@RequestBody String user){
		
		JSONObject jsonbook=new JSONObject(user);
		
		
		
		List<RoomInventory> bkdatelist = bookingService.checkindate(jsonbook.getString("checkInDate"));
//		
		
		return new ResponseEntity<List<RoomInventory>>(bkdatelist, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/updatebook", method = RequestMethod.POST)
	public ResponseEntity<Booking> updatebook(@RequestBody String user){
		System.out.println("In Microservice........."+user);
		JSONObject jsonbook=new JSONObject(user);
		
		Booking bk = bookingService.findbyid(jsonbook.getInt("bookingId"));
		
		bk.setStatus(jsonbook.getString("status"));
		
		Booking updatedbooking = bookingService.save(bk);
		
		return new ResponseEntity<Booking>(updatedbooking, HttpStatus.OK);
	}
}
