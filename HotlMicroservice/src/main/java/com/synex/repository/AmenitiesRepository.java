package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Amenities;

public interface AmenitiesRepository extends JpaRepository<Amenities, Integer> {

}
