package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.User;

public interface PointRepository extends JpaRepository<User, Integer>{

}
