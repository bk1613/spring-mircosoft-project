package com.synex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.synex.Repository.ItemRepository;
import com.synex.domain.Item;
import com.synex.domain.Status;

@Service
public class ItemService {

	@Autowired
	ItemRepository irepo;
	
	public Item findbyid(int id) {
		
		Optional<Item> it = irepo.findById(id);
		if(it.isEmpty()) {
			return null;
		}
		return it.get();
	}
	
	public List<Item> getallitems() {
		return irepo.findAll();
	}
	
	public Page<Item> getallitems(Pageable page) {
		return irepo.findAll(page);
	}
	
	public Item save(Item it) {
		return irepo.save(it);
	}
	
	public void delete(int id) {
		irepo.deleteById(id);
	}
	
	public void deleteall() {
		irepo.deleteAll();
	}
	
	public List<Item> findbyStatsUser(Status stat, String user) {
		return irepo.findByStatusAndUser(stat, user);
	}
	
}
