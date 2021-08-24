package com.hung.springh2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hung.springh2.model.Customer;
import com.hung.springh2.model.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Integer>, JpaSpecificationExecutor<Loans>{

	
}
