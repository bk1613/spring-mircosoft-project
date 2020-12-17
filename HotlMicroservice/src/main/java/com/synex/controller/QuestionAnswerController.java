package com.synex.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.QuestionAnswer;
import com.synex.service.QuestionAnswerService;

@CrossOrigin
@RestController
public class QuestionAnswerController {

	@Autowired
	QuestionAnswerService qaService;
	
	@PostMapping("getuserlistQA")
	public ResponseEntity<List<QuestionAnswer>> getlistuserQA(@RequestBody String hotel){
		JSONObject jsonQA = new JSONObject(hotel);
		System.out.println("Q&A");
		List<QuestionAnswer> QAs = qaService.getuserQAbyhotelId(jsonQA.getInt("hotelid"));
		
		for(var qa : QAs) {
			System.out.println(qa);
		}
		
		return new ResponseEntity<List<QuestionAnswer>>(QAs, HttpStatus.OK);
	}
	
	@PostMapping("getadminlistQA")
	public ResponseEntity<List<QuestionAnswer>> getlistadminQA(@RequestBody String hotel){
		JSONObject jsonQA = new JSONObject(hotel);
		System.out.println("Q&A");
		List<QuestionAnswer> QAs = qaService.getadminQAbyhotelId();
		
		for(var qa : QAs) {
			System.out.println(qa);
		}
		
		return new ResponseEntity<List<QuestionAnswer>>(QAs, HttpStatus.OK);
	}
	
	@PostMapping("saveQuestion")
	public ResponseEntity<QuestionAnswer> saveQA(@RequestBody QuestionAnswer QA){
		
		System.out.println("Q&A");
		QuestionAnswer QAs = qaService.save(QA);

		return new ResponseEntity<QuestionAnswer>(QAs, HttpStatus.OK);
	}
}
