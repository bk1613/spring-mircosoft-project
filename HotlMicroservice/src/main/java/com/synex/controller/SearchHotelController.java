package com.synex.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.domain.Amenities;
import com.synex.domain.Hotel;
import com.synex.domain.HotelReview;
import com.synex.domain.HotelRoom;
import com.synex.domain.RoomType;
import com.synex.domain.SearchDetails;
import com.synex.repository.HotelRepository;
import com.synex.repository.HotelReviewRepository;
import com.synex.service.HotelService;

@CrossOrigin
@RestController
public class SearchHotelController {

	@Autowired
	HotelService hotelservice;
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	HotelReviewRepository hotelReviewRepository;
	
	@PostMapping("saveAmentines")
	public ResponseEntity<Amenities> saveAmenities(@RequestBody Amenities amen){
		
		
		System.out.println(amen);
		amen = hotelservice.saveAmenties(amen);
		return new ResponseEntity<Amenities>(amen, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getHotelBySearch", method = RequestMethod.POST)
	public ResponseEntity<List<Hotel>> getHotel(@RequestBody String hotel){
		
		JSONObject jsonHotel=new JSONObject(hotel);
		Hotel javaHotel=new Hotel();
		SearchDetails searchhotel = new SearchDetails();
		searchhotel.setSearchHotel(jsonHotel.getString("searchHotel"));
		
		
		List<Hotel> HotelList = hotelRepository.findbyHotelName(searchhotel.getSearchHotel()+"%");

		return new ResponseEntity<List<Hotel>>(HotelList, HttpStatus.OK);
	}
	

	@PostMapping("ReviewHotel")
	public ResponseEntity<HotelReview> reviewHotel(@RequestBody HotelReview hotel){
		
		JSONObject jsonbook=new JSONObject(hotel);
		
		int starrate = hotel.getFoodRating() + hotel.getServiceRating() + hotel.getRoomRating() + hotel.getValueRating() + hotel.getCleanlinessRating();
		
		Hotel hot = hotelservice.findbyHotelid(hotel.getHotelId());
		
		hot.setStarRating(starrate/5);
		
		hotelservice.save(hot);
		
		HotelReview HR = hotelservice.createReview(hotel);
		
		return new ResponseEntity<HotelReview>(HR, HttpStatus.OK);
	}
	
	
	@PostMapping("getHotelReview")
	public ResponseEntity<List<HotelReview>> getreviewHotel(@RequestBody String hotel){
		
		JSONObject jsonreview=new JSONObject(hotel);
		
		jsonreview.getInt("hotelId");
		
		List<HotelReview> listHR = hotelReviewRepository.findHotellistbyid(jsonreview.getInt("hotelId"));
		
		for(var hl: listHR) {
			System.out.println(hl);
		}
		
		return new ResponseEntity<List<HotelReview>>(listHR, HttpStatus.OK);
	}
	
	@RequestMapping(value="create/hotel", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Hotel> createEmployee(@RequestBody Hotel hotel){
		
//		System.out.println("Hotel: " + hotel);
		
		Hotel h = hotelservice.save(hotel);
		return new ResponseEntity<Hotel>(h, HttpStatus.CREATED);
	}
	
	@PostMapping("saveRoom")
	public ResponseEntity<HotelRoom> createHotelRoom(@RequestBody JsonNode hotelroom){
		
		System.out.println(hotelroom.get("roomId").asInt());
		HotelRoom hr = new HotelRoom();
		hr.setRoomId(hotelroom.get("roomId").asInt());
		hr.setArea(hotelroom.get("area").asText());
		hr.setPrice(hotelroom.get("price").asDouble());
		hr.setDiscount(hotelroom.get("discount").asDouble());
		hr.setDescription(hotelroom.get("description").asText());
		hr.setPolicy(hotelroom.get("policy").asText());
		hr.setTotalroom(hotelroom.get("totalroom").asInt());
		hr.setRoomImage(hotelroom.get("roomImage").asText());
		
		RoomType rt = hotelservice.findRoomType(hotelroom.get("typeid").asInt());
		
		hr.setType(rt);
		System.out.println(hr);
		hr = hotelservice.saveHotelRoom(hr);
		return new ResponseEntity<HotelRoom>(hr, HttpStatus.CREATED);
	}
	@PostMapping("saveRoomtype")
	public ResponseEntity<RoomType> saveRoomType(@RequestBody RoomType roomtype){
		
		roomtype = hotelservice.saveRoomType(roomtype);
		
		return new ResponseEntity<RoomType>(roomtype, HttpStatus.CREATED);
	}
}
