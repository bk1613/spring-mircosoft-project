package com.synex.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String name);
}
