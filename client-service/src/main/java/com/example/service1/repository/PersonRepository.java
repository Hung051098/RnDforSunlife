package com.example.service1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service1.model.Customer;
import com.example.service1.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	
}
