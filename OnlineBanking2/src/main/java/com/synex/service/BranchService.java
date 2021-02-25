package com.synex.service;

import java.util.List;

import com.synex.domain.Branch;

public interface BranchService {
	public Branch save(Branch branch);
	
	public List<Branch> findAll();
	
	public Branch findBranchByid(Long branchId);
	
	public Branch findByName(String name);
	
	public void deleteBranchById(Long branchId);
	
	public Branch updateById(Long branchId);
	
	public Branch upadteBranch(Branch branch);
}
