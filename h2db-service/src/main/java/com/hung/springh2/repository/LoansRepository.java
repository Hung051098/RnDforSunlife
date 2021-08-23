package com.hung.springh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hung.springh2.model.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Integer>, JpaSpecificationExecutor<Loans>{

	
}
