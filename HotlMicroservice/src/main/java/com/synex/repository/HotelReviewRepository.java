package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synex.domain.HotelReview;

public interface HotelReviewRepository extends JpaRepository<HotelReview, Integer> {

	@Query(value = "SELECT * FROM hoteldb.hotelreview where hotelId =:hotelid", nativeQuery=true)
	public List<HotelReview> findHotellistbyid(int hotelid);
}
