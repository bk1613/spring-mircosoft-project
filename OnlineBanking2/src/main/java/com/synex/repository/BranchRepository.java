package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.synex.domain.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {
	@Transactional//to acoid, javax.persistence.TransactionRequiredException: Excuting an update/delete query
	@Modifying
	@Query("delete from Branch b where b.branchId=:branchId")//HQL or JPA QL being used here.
	public void deleteBranchById(@Param("branchId") long branchId);
}
