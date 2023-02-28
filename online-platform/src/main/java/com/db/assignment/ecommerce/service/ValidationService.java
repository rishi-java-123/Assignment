package com.db.assignment.ecommerce.service;

import java.util.Optional;

import com.db.assignment.ecommerce.model.Product;

public interface ValidationService {
	Optional<Product> validateProductByIdAndPrice(Long id, double Price);
}
