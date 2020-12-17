package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qaId;
	
	private String question;
	
	private String answer;
	
	private int hotelid;

	public QuestionAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionAnswer(int qaId, String question, int hotelid) {
		super();
		this.qaId = qaId;
		this.question = question;
		this.hotelid = hotelid;
	}

	public int getQaId() {
		return qaId;
	}

	public void setQaId(int qaId) {
		this.qaId = qaId;
	}


	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public QuestionAnswer(int qaId, String question, String answer, int hotelid) {
		super();
		this.qaId = qaId;
		this.question = question;
		this.answer = answer;
		this.hotelid = hotelid;
	}

	@Override
	public String toString() {
		return "QuestionAnswer [qaId=" + qaId + ", question=" + question + ", answer=" + answer + ", hotelid=" + hotelid
				+ "]";
	}
	
	
}
