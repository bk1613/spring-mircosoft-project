package com.synex.service;

import java.util.List;

import com.synex.domain.User;

public interface UserService {
	public List<User> findAll();

	public User save(User user);
	
	public User findbyid(int id);
	
	public void deletebyid(int id);
	
	public User findbyname(String name);
}
