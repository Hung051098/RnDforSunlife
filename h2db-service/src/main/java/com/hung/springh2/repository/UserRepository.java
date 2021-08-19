package com.hung.springh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hung.springh2.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
}
