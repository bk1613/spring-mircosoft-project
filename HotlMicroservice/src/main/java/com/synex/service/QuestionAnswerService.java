package com.synex.service;

import java.util.List;

import com.synex.domain.QuestionAnswer;

public interface QuestionAnswerService {

	public List<QuestionAnswer> getuserQAbyhotelId(int id);
	
	public List<QuestionAnswer> getadminQAbyhotelId();
	
	public QuestionAnswer save(QuestionAnswer q);
}
