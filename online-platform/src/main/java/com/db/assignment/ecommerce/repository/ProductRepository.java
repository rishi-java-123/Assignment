package com.db.assignment.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.assignment.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
