package com.synex.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synex.domain.Hotel;
import com.synex.domain.HotelRoom;
import com.synex.domain.RoomInventory;
import com.synex.domain.SearchDetails;
import com.synex.repository.HotelRepository;
import com.synex.repository.HotelRoomRepository;

@CrossOrigin
@RestController
public class SearchHotelRoomController {

	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	HotelRoomRepository hotelroomrepository;
	
	@RequestMapping(value = "/getHotelRoomsById", method = RequestMethod.POST)
	public ResponseEntity<Set<HotelRoom>> getHotelByName(@RequestBody String ocuppiedrooms) throws JsonMappingException, JsonProcessingException{
		System.out.println("In Microservice........."+ocuppiedrooms);
		
		JSONObject jsonocu=new JSONObject(ocuppiedrooms);
		
		JSONObject jsonHotel=new JSONObject(jsonocu.get("req1").toString());
		
		JSONArray jsonArray = new JSONArray(jsonocu.get("req2").toString());
		
//		ObjectMapper ob = new ObjectMapper();
//		
//		List<Object> rl = ob.readValue(jsonocu.get("req2").toString(),ArrayList.class);
//
//		System.out.println(rl);

		Hotel searchhotel = new Hotel();
		searchhotel.setHotelId(Integer.parseInt(jsonHotel.getString("hotelId")));
		
		Optional<Hotel> hotelitem = hotelRepository.findById(searchhotel.getHotelId());
//		Optional<Hotel> hote = hotelRepository.findById(searchhotel.getHotelId());
		
		System.out.println(jsonArray);
		System.out.println(hotelitem);
		
		
		Set<HotelRoom> listOfrooms = hotelitem.get().getHotelRooms();
		
		
		if(jsonArray.length() != 0) {
			Set<HotelRoom> Avaiablerooms = new HashSet<>();
			for(var ja: jsonArray) {
				JSONObject jso = new JSONObject(ja.toString());
				for(var room: listOfrooms) {
					if(room.getRoomId() == jso.getInt("roomId")) {
						if((room.getTotalroom() - jso.getInt("noRoom")) != 0) {
							Avaiablerooms.add(room);
						}
					}else {
						Avaiablerooms.add(room);	
					}
				}
				
				
			}
			return new ResponseEntity<Set<HotelRoom>>(Avaiablerooms, HttpStatus.OK);
		}else {
			return new ResponseEntity<Set<HotelRoom>>(listOfrooms, HttpStatus.OK);
		}
		
		
		
	}
	
	@RequestMapping(value = "/changeAvailableRooms", method = RequestMethod.POST)
	public ResponseEntity<Set<HotelRoom>> changeNoRoom(@RequestBody String ocuppiedrooms){
		System.out.println("In Microservice........."+ocuppiedrooms);
		
		JSONObject jsonocu=new JSONObject(ocuppiedrooms);
		System.out.println("req2 "+jsonocu.get("req2"));
//		for(var ocuro: jsonocu.get("Occupiedrooms")) {
//			
//		}
		

		return new ResponseEntity<Set<HotelRoom>>( HttpStatus.OK);
	}
	
	
}
