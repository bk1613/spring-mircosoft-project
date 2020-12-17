package com.synex.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.synex.domain.Role;
import com.synex.domain.User;

@Transactional
@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserService userservice;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("user");
		User userEntity = userservice.findbyname(username);
		System.out.println("userEntity: " + userEntity);
		Set<GrantedAuthority> authorities = new HashSet<>();// empty collection
		
		for(Role role : userEntity.getRoles()) {
			System.out.println("role: " + role);
			authorities.add(new SimpleGrantedAuthority(role.getRolename()));
		}
		
		return new org.springframework.security.core.userdetails.User(userEntity.getUsername(), userEntity.getPassword(), authorities);
	}

}
