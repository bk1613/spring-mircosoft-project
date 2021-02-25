package com.synex.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.synex.domain.Reservation;
import com.synex.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository resRepo;
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public Reservation saveReservation(Reservation res) {
		return resRepo.save(res);
	}
	
	public Reservation getReservation(int id) {
		Optional<Reservation> opres = resRepo.findById(id);
		if(opres.get() == null) {
			return null;
		}else {
			return opres.get();
		}
	}
	
	public List<Reservation> getReservations(){
		return resRepo.findAll();
	}
	
	public void cancelReservation(int id) {
		resRepo.deleteById(id);
	}
	
	//look into
	public  List<Reservation> findbybetweendates(LocalDate checkinDate, LocalDate checkoutDate) {
		return resRepo.findByCheckindateAfterAndCheckoutdateBeforeOrCheckindateBeforeAndCheckoutdateAfter(checkinDate, checkoutDate, checkinDate, checkoutDate);
	}
}
