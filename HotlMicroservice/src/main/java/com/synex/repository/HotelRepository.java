package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synex.domain.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	@Query(value = "select * from hotel where hotelname like :searchkey or city like :searchkey or state like :searchkey", nativeQuery=true)
	public List<Hotel> findbyHotelName(String searchkey);
}
