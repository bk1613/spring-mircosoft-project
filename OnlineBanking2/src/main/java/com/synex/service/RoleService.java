package com.synex.service;

import java.util.List;

import com.synex.domain.Role;

public interface RoleService {
	public Role createRole(Role role);
	public List<Role> findAll();
	public Role findByName(String Name);
	public void delete(long roleid); 
	public Role findById(long id);
}
