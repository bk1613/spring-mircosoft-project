package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
