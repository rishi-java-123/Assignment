package com.db.assignment.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.db.assignment.ecommerce.dtos.ProductTitleAndDescriptionResponse;
import com.db.assignment.ecommerce.model.Product;

public interface ProductService {
	Product addProduct(Product product);
	List<Product> getAllProduct();
	Product deleteProduct(Long id);
	void updateProduct(Product product);
	Optional<Product> getProduct(Product product);
	List<ProductTitleAndDescriptionResponse> getPrductforListing();
}
