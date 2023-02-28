package com.db.assignment.ecommerce.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.assignment.ecommerce.model.Product;
import com.db.assignment.ecommerce.repository.ProductRepository;
import com.db.assignment.ecommerce.service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService{
	
	@Autowired
	ProductRepository productRepository;

	public Optional<Product> validateProductByIdAndPrice(Long id, double Price) {
		return	productRepository.findById(id);
		
		
	}
}
