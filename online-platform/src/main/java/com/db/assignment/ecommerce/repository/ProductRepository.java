package com.db.assignment.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.db.assignment.ecommerce.dtos.ProductTitleAndDescriptionResponse;
import com.db.assignment.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("Select new com.db.assignment.ecommerce.dtos.ProductTitleAndDescriptionResponse (title, description) FROM  Product product")
	List<ProductTitleAndDescriptionResponse> findTitleDescription();

	//@Query("Select new com.db.assignment.ecommerce.dtos.ProductIdAndPriceResponse(Id, price) FROM  Product product where product.productId = ?1")
	//Product findProductAndPriceById(long productId);
}
