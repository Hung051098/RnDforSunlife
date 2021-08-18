package com.example.configservice1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.configservice1.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
}
