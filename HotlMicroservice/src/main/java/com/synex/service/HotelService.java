package com.synex.service;

import java.util.List;

import com.synex.domain.Hotel;
import com.synex.domain.HotelReview;

public interface HotelService {
	public Hotel findbyHotelid(int id);
	
	public Hotel save(Hotel hotel);
	
	public HotelReview createReview(HotelReview HR);
}
