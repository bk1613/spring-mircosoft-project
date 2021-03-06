package com.synex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.synex.repository.ItemRepository;
import com.synex.model.Item;
import com.synex.model.Status;

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
		List<Item> itl = new ArrayList<>();
		irepo.findAll().forEach(itl::add);
		return itl;
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
	
	
}
