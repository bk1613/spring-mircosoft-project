package com.synex.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.synex.domain.Booking;
import com.synex.domain.RoomInventory;

@Repository
public class BookingDaoImpl implements BookingDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<RoomInventory> findbookcheckindate(String checkingin) {
		// TODO Auto-generated method stub
		String sql = "SELECT HotelroomID, sum(noRooms) noOccupiedRooms FROM hoteldb.booking "
                + "where (? >= checkindate "
                + "AND ? <  checkoutdate) "
                + "or (? >= checkindate  "
                + "AND ? <=  checkoutdate) "
                + "GROUP BY HotelRoomId";
		
		Object[] args = {checkingin, checkingin, checkingin, checkingin};
		List<RoomInventory> roomlist = jdbcTemplate.query(sql, args, new RoomMapper());
		
		System.out.println(roomlist);
		
		return roomlist;
	}

	@Override
	public List<Booking> findbyuser(String user) {
		// TODO Auto-generated method stub
		String sql = "select b.*, hr.hotelName from hoteldb.booking b, hoteldb.hotel hr where username = ? and b.hotelId = hr.hotelId";
		
		Object[] args = {user};
		
		List<Booking> booklist = jdbcTemplate.query(sql, args, new BookMapper());
		return booklist;
	}


}

class RoomMapper implements RowMapper<RoomInventory>{
    @Override
    public RoomInventory mapRow(ResultSet rs, int rowNum) throws SQLException {
        RoomInventory roomInventory = new RoomInventory();
        roomInventory.setRoomId(rs.getInt("HotelroomID"));
        roomInventory.setNoRoom(rs.getInt("noOccupiedRooms"));
        return roomInventory;
    }
    
}

class BookMapper implements RowMapper<Booking>{
    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Booking bk = new Booking();
    	bk.setBookingId(rs.getInt("bookingId"));
    	bk.setHotelId(rs.getInt("hotelId"));
    	bk.setHotelRoomId(rs.getInt("hotelRoomId"));
    	bk.setUserName(rs.getString("userName"));
    	bk.setRoomType(rs.getString("roomType"));
    	bk.setStatus(rs.getString("status"));
    	bk.setCheckInDate(rs.getString("checkInDate"));
    	bk.setCheckOutDate(rs.getString("checkOutDate"));
    	bk.setNoRooms(rs.getInt("noRooms"));
        bk.setHotelName(rs.getString("hotelName"));
        
        return bk;
    }
    
}