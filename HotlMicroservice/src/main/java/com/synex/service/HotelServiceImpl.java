package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Amenities;
import com.synex.domain.Hotel;
import com.synex.domain.HotelReview;
import com.synex.domain.HotelRoom;
import com.synex.domain.RoomType;
import com.synex.repository.AmenitiesRepository;
import com.synex.repository.HotelRepository;
import com.synex.repository.HotelReviewRepository;
import com.synex.repository.HotelRoomRepository;
import com.synex.repository.RoomTypeRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	HotelReviewRepository hotelReviewRepository;
	
	@Autowired
	AmenitiesRepository amenRepo;
	
	@Autowired
	RoomTypeRepository rtRepo;
	
	@Autowired
	HotelRoomRepository hrRepo;
	
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

	@Override
	public Amenities saveAmenties(Amenities amen) {
		// TODO Auto-generated method stub
		
		return amenRepo.save(amen);
	}

	@Override
	public HotelRoom saveHotelRoom(HotelRoom HR) {
		// TODO Auto-generated method stub
		return hrRepo.save(HR);
	}

	@Override
	public RoomType saveRoomType(RoomType rm) {
		// TODO Auto-generated method stub
		return rtRepo.save(rm);
	}

	@Override
	public RoomType findRoomType(int id) {
		// TODO Auto-generated method stub
		Optional<RoomType> rtop = rtRepo.findById(id);
		if(rtop.get() == null) {
			return null;
		}else {
			return rtop.get();
		}
		
	}

	@Override
	public HotelRoom findHotelRoo(int id) {
		// TODO Auto-generated method stub
		Optional<HotelRoom> rtop = hrRepo.findById(id);
		if(rtop.get() == null) {
			return null;
		}else {
			return rtop.get();
		}
		
	}

}
