package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Laundryitems;

public interface LaundryItemsRepository extends JpaRepository<Laundryitems, Integer> {

}
