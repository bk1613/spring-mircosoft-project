package com.synex.service;

import java.util.List;

import com.synex.domain.Booking;
import com.synex.domain.RoomInventory;

public interface BookingService {
	public Booking save(Booking bk);
	
	public List<RoomInventory> checkindate(String checkingin);
	
	public List<Booking> findbyuser(String user);
	
	public Booking findbyid(int bookingId);
	
}
