package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Role;
import com.synex.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role createRole(Role role) {
		// TODO Auto-generated method stub
//		System.out.println(findByName(role.getName()).getName());
		if( findById(role.getRoleId())==null || findByName(role.getName())==null ) {
			return roleRepository.save(role);
		}else {
			System.out.println("Already have this role");
		}
		return null;
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public void delete(long roleId) {
		// TODO Auto-generated method stub
		roleRepository.deleteRoleById(roleId);
	}

	@Override
	public Role findByName(String name) {

		return roleRepository.findByName(name);
		
	}
	
	@Override
	public Role findById(long id) {
		Optional<Role> optrole = roleRepository.findById(id);
		if(optrole.isPresent()) {
		return optrole.get();
		}else {
			System.out.println("Role id " + id + " does not exist.");
			return null;
		}
	}

}
