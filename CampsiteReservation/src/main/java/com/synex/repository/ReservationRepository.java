package com.synex.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	public List<Reservation> findByCheckindateAfterAndCheckoutdateBeforeOrCheckindateBeforeAndCheckoutdateAfter(LocalDate checkindate, LocalDate checkoutdate, LocalDate checkindate2, LocalDate checkoutdate2);
	
}
