package com.synex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.model.Xfile;

public interface FileRepository extends JpaRepository<Xfile, Integer> {

	List<Xfile> findByFileGroup(String fileGroup);
	
	Xfile findByFileGroupAndFileName(String fileGroup, String fileName);
	
}
