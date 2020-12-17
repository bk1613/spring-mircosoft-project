package com.synex.repository;

import org.springframework.data.repository.CrudRepository;

import com.synex.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
