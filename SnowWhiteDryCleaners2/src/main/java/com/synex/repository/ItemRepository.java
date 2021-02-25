package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Items;

public interface ItemRepository extends JpaRepository<Items, Integer> {

}
