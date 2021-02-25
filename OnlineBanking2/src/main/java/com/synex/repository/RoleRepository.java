package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.synex.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	@Transactional//to acoid, javax.persistence.TransactionRequiredException: Excuting an update/delete query
	@Modifying
	@Query("delete from Role r where r.roleId=:roleId")//HQL or JPA QL being used here.
	public void deleteRoleById(@Param("roleId") long roleId);
	
	public Role findByName(String name);
}
