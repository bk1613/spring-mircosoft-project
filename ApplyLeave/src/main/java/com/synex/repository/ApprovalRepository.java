package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.LeaveApproval;

public interface ApprovalRepository extends JpaRepository<LeaveApproval, Integer> {

}
