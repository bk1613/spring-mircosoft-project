package com.synex.dao;

import java.util.List;

import com.synex.domain.Booking;
import com.synex.domain.RoomInventory;

public interface BookingDao {
	public List<RoomInventory> findbookcheckindate(String checkingin);
	
	public List<Booking> findbyuser(String user);
}
