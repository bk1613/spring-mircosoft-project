package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Branch;
import com.synex.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	BranchRepository branchRepository;
	
	@Override
	public Branch save(Branch branch) {
		return branchRepository.save(branch);
	}

	@Override
	public List<Branch> findAll() {
		return branchRepository.findAll();
	}

	@Override
	public Branch findBranchByid(Long branchId) {
		Optional<Branch> optEmployee = branchRepository.findById(branchId);
			if(optEmployee.isPresent()) {
		return optEmployee.get();
		}else {
			System.out.println("Branch id " + branchId + " does not exist.");
			return null;
		}
		
	}

	@Override
	public Branch findByName(String name) {
		return null;
	}

	@Override
	public void deleteBranchById(Long branchId) {
		branchRepository.deleteBranchById(branchId);
	}

	@Override
	public Branch updateById(Long branchId) {
		return null;
	}

	@Override
	public Branch upadteBranch(Branch branch) {
		return branchRepository.save(branch);
	}




	

}
