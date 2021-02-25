package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Laundryrequest;

public interface LaundryRequestsRepository extends JpaRepository<Laundryrequest, Integer> {

}
