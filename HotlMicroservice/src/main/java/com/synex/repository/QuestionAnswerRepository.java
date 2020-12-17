package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synex.domain.QuestionAnswer;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Integer> {

	@Query(value = "SELECT * FROM hoteldb.questionanswer where hotelid=:id and Answer is not null", nativeQuery=true)
	public List<QuestionAnswer> finduserQAByHotelId(int id);
	
	@Query(value = "SELECT * FROM hoteldb.questionanswer where Answer is null", nativeQuery=true)
	public List<QuestionAnswer> findadminQAByHotelId();
}
