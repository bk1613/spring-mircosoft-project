package com.synex.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
