package com.synex.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.model.Person;

public interface ContactRepository extends JpaRepository<Person, Integer> {

}
