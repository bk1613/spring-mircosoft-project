package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
