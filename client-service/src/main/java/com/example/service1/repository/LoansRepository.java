package com.example.service1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service1.model.Customer;
import com.example.service1.model.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Integer>{

	
}
