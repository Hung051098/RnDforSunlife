package com.example.service1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service1.model.Address;
import com.example.service1.model.Customer;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

	
}