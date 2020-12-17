package com.synex.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Booking;
import com.synex.domain.Hoteladdress;
import com.synex.domain.RoomInventory;
import com.synex.repository.BookingRepository;
import com.synex.dao.BookingDao;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	BookingDao bookingdao;
	
	@Override
	public Booking save(Booking bk) {
		// TODO Auto-generated method stub
		Booking book = bookingRepository.save(bk);
		System.out.println("save");
		book.setHotelName(bookingRepository.findHotelnameByid(book.getHotelId()));
		book.setAddress(bookingRepository.findAdressByid(book.getHotelId()));
		book.setCity(bookingRepository.findCityByid(book.getHotelId()));
		book.setState(bookingRepository.findStateByid(book.getHotelId()));
		book.setImageURL(bookingRepository.findImageByid(book.getHotelId()));
		return book;
	}

	@Override
	public List<RoomInventory> checkindate(String checkingin) {
		// TODO Auto-generated method stub
		
		return bookingdao.findbookcheckindate(checkingin);
	}

	@Override
	public List<Booking> findbyuser(String user) {
		// TODO Auto-generated method stub
		return bookingdao.findbyuser(user);
	}

	@Override
	public Booking findbyid(int bookingId) {
		// TODO Auto-generated method stub
		Optional<Booking> bk = bookingRepository.findById(bookingId);
		return bk.get();
	}

}
