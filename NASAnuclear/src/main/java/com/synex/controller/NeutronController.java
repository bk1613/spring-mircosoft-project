package com.synex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Neutron;

@RestController
public class NeutronController {

	@PostMapping("increaseBombardment")
	public ResponseEntity<?> increaseNeutron(@RequestBody Neutron neu){
		
		System.out.println(neu);
		
		Neutron neutron = new Neutron();
		System.out.println(neutron.getNoOfNeutron());
		neutron.setNoOfNeutron(neutron.getNoOfNeutron() + neu.getNoOfNeutron());
		
		if(neutron.getNoOfNeutron() >= 1000000000) {
			neutron.setNoOfNeutron(neutron.getNoOfNeutron()/2);
			throw new SafeShutdownException("The number has exceeded its compacity, it has been halved");
		}
		
		return new ResponseEntity<Neutron>(neutron, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("decreaseBombardment")
	public ResponseEntity<?> decreaseNeutron(@RequestBody Neutron neu){
		
		System.out.println(neu);
		
		Neutron neutron = new Neutron();
		System.out.println(neutron.getNoOfNeutron());
		neutron.setNoOfNeutron(neutron.getNoOfNeutron() - neu.getNoOfNeutron());
		
		return new ResponseEntity<Neutron>(HttpStatus.ACCEPTED);
	}
	
}
