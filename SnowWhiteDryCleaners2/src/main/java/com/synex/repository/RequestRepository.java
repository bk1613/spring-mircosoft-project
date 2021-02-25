package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Request;

public interface RequestRepository extends JpaRepository<Request, Integer> {

}
