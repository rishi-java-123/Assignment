package com.db.assignment.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.assignment.ecommerce.model.Product;
import com.db.assignment.ecommerce.model.Status;
import com.db.assignment.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	public Product addProduct(Product product) {
		Product savedProduct = productRepository.save(product);

		return savedProduct;
	}

	public Product deleteProduct(Long id) {
		Product productToRemove = productRepository.findById(id).orElse(null);

		// check if status is SOLD, if not then set it DELETED
		if (productToRemove.getStatus() != Status.SOLD) {
			productToRemove.setStatus(Status.DELETED);
		}

		return productRepository.save(productToRemove);
	}

	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	public Optional<Product> getProduct(Product product) {
		return productRepository.findById(product.getProductId());
	}

}
