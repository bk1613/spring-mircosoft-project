package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Role;
import com.synex.repo.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role save(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public Role findbyid(int id) {
		// TODO Auto-generated method stub
		Optional<Role> optrole = roleRepository.findById(id);
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
		roleRepository.deleteById(id);
	}

}
