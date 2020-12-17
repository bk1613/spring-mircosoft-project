package com.synex.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synex.domain.Item;
import com.synex.domain.Status;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	@Query(value = "select * from hoteldb.Item where itemStatus =:stat OR itemEnterByUser =:user", nativeQuery=true)
	public List<Item> findByStatusAndUser(Status stat, String user);
	
	public Page<Item> findAll(Pageable pageable);

}
