package com.synex.service;

import java.util.List;


import com.synex.domain.Amenities;
import com.synex.domain.Hotel;
import com.synex.domain.HotelReview;
import com.synex.domain.HotelRoom;
import com.synex.domain.RoomType;

public interface HotelService {
	public Hotel findbyHotelid(int id);
	
	public Hotel save(Hotel hotel);
	
	public HotelReview createReview(HotelReview HR);
	
	public Amenities saveAmenties(Amenities amen);
	
	public HotelRoom saveHotelRoom(HotelRoom HR);
	
	public RoomType saveRoomType(RoomType rm);
	
	public RoomType findRoomType(int id);
	
	public HotelRoom findHotelRoo(int id);
}
