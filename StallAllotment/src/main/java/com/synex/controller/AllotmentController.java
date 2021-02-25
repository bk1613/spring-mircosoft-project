package com.synex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.synex.domain.Allotment;

@Controller
public class AllotmentController {

	
	@PostMapping("saveallot")
	public String saveAllotment(@ModelAttribute Allotment allotment) {
		
		return "AllotmentForm";
	}
	
	
}
