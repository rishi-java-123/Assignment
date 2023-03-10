package com.db.assignment.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.assignment.ecommerce.dtos.ProductTitleAndDescriptionResponse;
import com.db.assignment.ecommerce.model.Product;
import com.db.assignment.ecommerce.model.Status;
import com.db.assignment.ecommerce.repository.ProductRepository;
import com.db.assignment.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product deleteProduct(Long id) {
		Product productToRemove = productRepository.findById(id).orElse(null);

		// check if status is SOLD, if not then set it DELETED
		if (productToRemove.getStatus() != Status.SOLD) {
			productToRemove.setStatus(Status.DELETED);
		}

		return productRepository.save(productToRemove);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public Optional<Product> getProduct(Product product) {
		return productRepository.findById(product.getProductId());
	}

	@Override
	public List<ProductTitleAndDescriptionResponse> getPrductforListing() {

		return productRepository.findTitleDescription();
	}

}
