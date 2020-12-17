package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Guest;
import com.synex.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	GuestRepository guestrepository;
	
	@Override
	public Guest save(Guest gt) {
		// TODO Auto-generated method stub
		return guestrepository.save(gt);
	}

}
