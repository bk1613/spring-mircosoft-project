package com.synex.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.domain.DateAvaiavble;
import com.synex.domain.Reservation;
import com.synex.domain.Status;
import com.synex.service.ReservationService;

@RestController
public class ReservationController {

	@Autowired
	ReservationService resSer;
	
	@PostMapping("bookreservatin")
	public ResponseEntity<?> makeReservation(@RequestBody Reservation res){
		
		List<Reservation> list = resSer.getReservations();
		for(Reservation r : list) {
			
			Period period = Period.between(res.getCheckindate(), res.getCheckoutdate());
			int diff = Math.abs(period.getDays());
			if(diff > 3) {
				throw new ReservstionException("exceed number of days to day");
			}
			if(r.getCheckindate().equals(res.getCheckindate())) {
				throw new ReservstionException("checkindate already reserved");
			}
		}
		
		System.out.println(res);
		res = resSer.saveReservation(res);
		
		return new ResponseEntity<Reservation>(res, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("checkreservation")
	public ResponseEntity<?> checkReservation(@RequestBody JsonNode dates) throws ParseException{
		List<DateAvaiavble> list = new ArrayList<>();
		Status s= null;

		if((dates.get("checkindate") == null || dates.get("checkoutdate") == null) || dates.get("checkindate").asText().isEmpty() && dates.get("checkoutdate").asText().isEmpty()) {
			LocalDate currdate = LocalDate.now();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try{
			   //Setting the date to the given date
			   c.setTime(sdf.parse(currdate.toString()));
			}catch(ParseException e){
				e.printStackTrace();
			}
			c.add(Calendar.DAY_OF_MONTH, 30); 
			LocalDate newDate = LocalDate.parse(sdf.format(c.getTime()));
			
			System.out.println(newDate);
			
			for (LocalDate date = currdate; date.isBefore(newDate); date = date.plusDays(1)) {
				DateAvaiavble da = new DateAvaiavble();
				da.setDate(date);
		        da.setStatus(s.AVAILABLE);
				list.add(da);
				
			}
			System.out.println(currdate);
			List<Reservation> re = resSer.getReservations();
			System.out.println(re);
			for(DateAvaiavble d: list) {
				for(int i = 0; i < re.size(); i++) {
					if(currdate.isAfter(re.get(i).getCheckindate()) || re.get(i).getCheckindate().isBefore(newDate)) {
						
						if(d.getDate().equals(re.get(i).getCheckindate())) {
							System.out.println(d.getDate() + " " + re.get(i).getCheckindate());
							System.out.println(d.getDate());
							d.setStatus(s.RESERVED);
						}
						
					}
				}
			}
			
		}else if (!dates.get("checkindate").asText().isEmpty() && !dates.get("checkoutdate").asText().isEmpty()){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
			
			LocalDate checkindate = LocalDate.parse(dates.get("checkindate").asText(), formatter);
			System.out.println(checkindate);
		
			LocalDate checkoutdate = LocalDate.parse(dates.get("checkoutdate").asText(), formatter);
			System.out.println(checkoutdate);
			
			
			List<Reservation> re = resSer.findbybetweendates(checkindate, checkoutdate);
			//System.out.println(re);
			

			for (LocalDate date = checkindate; date.isBefore(checkoutdate); date = date.plusDays(1)) {
		        
				DateAvaiavble da = new DateAvaiavble();
		        da.setDate(date);
		        da.setStatus(s.AVAILABLE);
		        //System.out.println(da);
		        list.add(da);
		    }
			
			for(DateAvaiavble d: list) {
				for(int i = 0; i < re.size(); i++) {
//				if(checkindate.isAfter(re.get(i).getCheckindate()) || re.get(i).getCheckindate().isBefore(newDate)) {
					//
					if(d.getDate().equals(re.get(i).getCheckindate())) {
						System.out.println(d.getDate() + " " + re.get(i).getCheckindate());
						d.setStatus(s.RESERVED);
					}
					
//				}
				}
			}
			
		}
		
		return new ResponseEntity<List<DateAvaiavble>>(list, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getreservatins")
	public ResponseEntity<List<Reservation>> getReservations(){
		
		
		List<Reservation> list = resSer.getReservations();
		
		return new ResponseEntity<List<Reservation>>(list, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("modifyreservatins")
	public ResponseEntity<Reservation> updateReservations(@RequestBody JsonNode datechange){
		
		if(datechange.get("status") != null){
			if(datechange.get("status").asText().equals("cancel")) {
				int id = datechange.get("id").asInt();
				Reservation canRes = resSer.getReservation(id);
				if(canRes != null) {
					resSer.cancelReservation(id);
				}
				
			}
			return new ResponseEntity<Reservation>(HttpStatus.ACCEPTED);
		}else {
			int id = datechange.get("id").asInt();
			Reservation canRes = resSer.getReservation(id);
			if(canRes != null) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
				
				LocalDate checkindate = LocalDate.parse(datechange.get("checkindate").asText(), formatter);
				
			
				LocalDate checkoutdate = LocalDate.parse(datechange.get("checkoutdate").asText(), formatter);
				canRes.setCheckindate(checkindate);
				canRes.setCheckoutdate(checkoutdate);
				resSer.saveReservation(canRes);
				
			}
			return new ResponseEntity<Reservation>(canRes, HttpStatus.ACCEPTED);
		}
		
		
		
	}
	
	@GetMapping("cancelreservatins")
	public ResponseEntity<List<Reservation>> cancelReservations(@PathVariable JsonNode cancel){
		
		int id = cancel.get("id").asInt();
		Reservation canRes = resSer.getReservation(id);
		
		return new ResponseEntity<List<Reservation>>(HttpStatus.ACCEPTED);
	}
	
}
