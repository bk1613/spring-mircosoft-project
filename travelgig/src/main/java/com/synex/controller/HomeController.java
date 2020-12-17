package com.synex.controller;

import java.security.Principal;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synex.restclient.HotelRestClient;

@Controller
public class HomeController {

	@Autowired
	HotelRestClient hotelRestClient;
	
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String getHotelView(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		model.addAttribute("currentUser", auth.getName());
		
		return "hotel";
	}
	
	@RequestMapping(value ="/gethotel", method = RequestMethod.POST)
	public ResponseEntity<String> getHotel(@RequestBody String jsonString) throws JSONException, JsonProcessingException {
		System.out.println("Inside TravelGig Controller"+jsonString);
		
		JSONObject jsonObject = new JSONObject(jsonString);
		JSONObject jsonResponseObject = hotelRestClient.getHotel(jsonObject);
		
		System.out.println(jsonResponseObject);
		
		return new ResponseEntity<String>(jsonResponseObject.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getroom", method = RequestMethod.POST)
	public ResponseEntity<String> getHotelRoom(@RequestBody String jsonString) throws JSONException, JsonProcessingException {
		
		System.out.println("Inside TravelGig Controller"+jsonString);
		
		JSONObject jsonObject = new JSONObject(jsonString);
		JSONObject jsonResponseObject = hotelRestClient.getHotelRoom(jsonObject);
//		
//		System.out.println(jsonResponseObject);
		
		return new ResponseEntity<String>(jsonResponseObject.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value ="/savebooking", method = RequestMethod.POST)
	public ResponseEntity<String> saveBooking(@RequestBody String jsonString) throws JSONException, JsonProcessingException {
		System.out.println("Inside TravelGig Controller"+jsonString);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JSONObject jsonObject = new JSONObject(jsonString);
		
		System.out.println(auth.getName());
		
		jsonObject.put("userName", auth.getName());
		
		
		
		JSONObject jsonResponseObject = hotelRestClient.bookHotelRoom(jsonObject);
		
		return new ResponseEntity<String>(jsonResponseObject.toString(), HttpStatus.OK);
	}
	
	@GetMapping(value ="/validateBooking")
	public ResponseEntity<String> getBooking() throws JSONException, JsonProcessingException {
		
		System.out.println("dsf");
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}
	
	@GetMapping(value ="/getBooking")
	public ResponseEntity<String> validateBooking() throws JSONException, JsonProcessingException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JSONObject jsonObject = new JSONObject();
		
		System.out.println(auth.getName());
		
		jsonObject.put("userName", auth.getName());
		JSONObject jsonResponseObject = hotelRestClient.getBook(jsonObject);
		
		System.out.println(jsonResponseObject);
		
		return new ResponseEntity<String>(jsonResponseObject.toString(), HttpStatus.OK);
	}
	
	@PostMapping(value ="/updateBookingStatus")
	public ResponseEntity<String> updateBookingstatus(@RequestBody String jsonString) throws JSONException, JsonProcessingException {
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JSONObject jsonObject = new JSONObject(jsonString);
		
		System.out.println(auth.getName());
		
		jsonObject.put("userName", auth.getName());
		JSONObject jsonResponseObject = hotelRestClient.updateBooking(jsonObject);
		
		System.out.println(jsonResponseObject);
		
		return new ResponseEntity<String>(jsonResponseObject.toString(), HttpStatus.OK);
	}
	
	@PostMapping(value ="/reviewHotel")
	public ResponseEntity<String> revHotel(@RequestBody String jsonString) throws JSONException, JsonProcessingException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JSONObject jsonObject = new JSONObject(jsonString);
		
		System.out.println(auth.getName());
		
		jsonObject.put("userName", auth.getName());
		
		JSONObject jsonResponseObject = hotelRestClient.reviewHotel(jsonObject);
		
		
		return new ResponseEntity<String>(jsonResponseObject.toString(), HttpStatus.OK);
	}
	
	@PostMapping(value ="/getHotelreview")
	public ResponseEntity<String> getreviewHotel(@RequestBody String jsonString) throws JSONException, JsonProcessingException {

//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JSONObject jsonObject = new JSONObject(jsonString);
		
//		System.out.println(auth.getName());
//		
//		jsonObject.put("userName", auth.getName());
		
		JSONObject jsonResponseObject = hotelRestClient.getHotelReview(jsonObject);
		
		
		return new ResponseEntity<String>(jsonResponseObject.toString(), HttpStatus.OK);
	}
	
	@PostMapping(value ="/getuserQAs")
	public ResponseEntity<String> getuserlistQA(@RequestBody String jsonString) throws JSONException, JsonProcessingException {

		System.out.println("user Question and Answer");
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JSONObject jsonObject = new JSONObject(jsonString);
		
//		System.out.println(auth.getName());
//		
//		jsonObject.put("userName", auth.getName());
		
		JSONObject jsonResponseObject = hotelRestClient.getuserlistQA(jsonObject);
		
		
		return new ResponseEntity<String>(jsonResponseObject.toString(), HttpStatus.OK);
	}
	
	@GetMapping(value ="/getadminQAs")
	public ResponseEntity<String> getadminlistQA() throws JSONException, JsonProcessingException {

		System.out.println("admin Question and Answer");
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JSONObject jsonObject = new JSONObject();
		
//		System.out.println(auth.getName());
//		
//		jsonObject.put("userName", auth.getName());
		
		JSONObject jsonResponseObject = hotelRestClient.getadminlistQA(jsonObject);
		
		
		return new ResponseEntity<String>(jsonResponseObject.toString(), HttpStatus.OK);
	}
	
	@PostMapping(value ="/saveQA")
	public ResponseEntity<String>saveQuestion(@RequestBody String jsonString) throws JSONException, JsonProcessingException {

		System.out.println("Question and Answer");

		JSONObject jsonObject = new JSONObject(jsonString);
		
		
		JSONObject jsonResponseObject = hotelRestClient.saveQues(jsonObject);
		
		
		return new ResponseEntity<String>(jsonResponseObject.toString(), HttpStatus.OK);
	}
	
	
	
}
