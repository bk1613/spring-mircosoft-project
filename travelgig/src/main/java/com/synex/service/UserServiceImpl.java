package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synex.domain.User;
import com.synex.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User findbyid(int id) {
		// TODO Auto-generated method stub
		Optional<User> optrole = userRepository.findById(id);
		if(optrole.isPresent()) {
		return optrole.get();
		}else {
			System.out.println("Role id " + id + " does not exist.");
			return null;
		}
	}

	@Override
	public void deletebyid(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public User findbyname(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(name);
	}

}
