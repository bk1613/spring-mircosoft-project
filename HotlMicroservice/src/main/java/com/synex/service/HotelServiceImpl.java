package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Hotel;
import com.synex.domain.HotelReview;
import com.synex.repository.HotelRepository;
import com.synex.repository.HotelReviewRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	HotelReviewRepository hotelReviewRepository;
	
	@Override
	public Hotel findbyHotelid(int id) {
		// TODO Auto-generated method stub
		Optional<Hotel> hotel = hotelRepository.findById(id);
		return hotel.get();
	}

	@Override
	public Hotel save(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}

	@Override
	public HotelReview createReview(HotelReview HR) {
		// TODO Auto-generated method stub
		return hotelReviewRepository.save(HR);
	}

}
