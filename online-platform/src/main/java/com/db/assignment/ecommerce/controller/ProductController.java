package com.db.assignment.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.assignment.ecommerce.dtos.ProductTitleAndDescriptionResponse;
import com.db.assignment.ecommerce.dtos.Response;
import com.db.assignment.ecommerce.dtos.ResponseTypeEnum;
import com.db.assignment.ecommerce.model.Product;
import com.db.assignment.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/add")
	public Response<?> addProduct(@RequestBody Product product) {
		try {
			return new Response<Product>(ResponseTypeEnum.SUCCESS, productService.addProduct(product));
		} catch (Exception e) {
			return new Response<String>(ResponseTypeEnum.ERROR, e.getMessage());
		}

	}
	
	@GetMapping("/")
	public List<ProductTitleAndDescriptionResponse> getAllProductForListing() {
		return productService.getPrductforListing();
	}
	

}
