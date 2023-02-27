package com.db.assignment.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.assignment.ecommerce.model.User;


public interface UserRepository extends JpaRepository<User,Long>{

	User findByEmail(String email);
}