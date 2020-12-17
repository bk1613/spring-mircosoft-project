package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synex.domain.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	@Query(value = "select b.*, hr.hotelName from hoteldb.booking b, hoteldb.hotel hr where username =:user group by b.hotelId", nativeQuery=true)
	public List<Booking> findByUsername(String user);
	
	@Query(value = "select hotelName from hoteldb.hotel where hotelId =:hotelid", nativeQuery=true)
	public String findHotelnameByid(int hotelid);
	
	@Query(value = "select address from hoteldb.hotel where hotelId =:hotelid", nativeQuery=true)
	public String findAdressByid(int hotelid);
	
	@Query(value = "select city from hoteldb.hotel where hotelId =:hotelid", nativeQuery=true)
	public String findCityByid(int hotelid);
	
	@Query(value = "select state from hoteldb.hotel where hotelId =:hotelid", nativeQuery=true)
	public String findStateByid(int hotelid);
	
	@Query(value = "select imageURL from hoteldb.hotel where hotelId =:hotelid", nativeQuery=true)
	public String findImageByid(int hotelid);

}
