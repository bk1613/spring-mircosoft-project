package com.synex.service;

import java.util.List;

import com.synex.domain.Role;

public interface RoleService {
	public List<Role> findAll();

	public Role save(Role role);
	
	public Role findbyid(int id);
	
	public void deletebyid(int id);
}
