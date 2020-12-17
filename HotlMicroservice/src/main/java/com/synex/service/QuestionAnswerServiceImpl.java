package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.QuestionAnswer;
import com.synex.repository.QuestionAnswerRepository;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

	@Autowired
	QuestionAnswerRepository questionAnswerRepository;

	@Override
	public List<QuestionAnswer> getuserQAbyhotelId(int id) {
		// TODO Auto-generated method stub
		return questionAnswerRepository.finduserQAByHotelId(id);
	}

	@Override
	public QuestionAnswer save(QuestionAnswer q) {
		// TODO Auto-generated method stub
		return questionAnswerRepository.save(q);
	}

	@Override
	public List<QuestionAnswer> getadminQAbyhotelId() {
		// TODO Auto-generated method stub
		return questionAnswerRepository.findadminQAByHotelId();
	}
	
}
