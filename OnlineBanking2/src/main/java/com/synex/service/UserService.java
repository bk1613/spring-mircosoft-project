package com.synex.service;

import java.util.List;

import com.synex.domain.User;

public interface UserService {
	public User createUser(User user);
	
	public User findbyName(String name);
	
	public User findbyid(long id);
	
	public List<User> findAll();
	
	public void delete(long id);
}
