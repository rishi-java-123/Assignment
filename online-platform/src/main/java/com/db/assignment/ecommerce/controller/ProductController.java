package com.db.assignment.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {
	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	/**
	 * @param product
	 * @return Response message after saving product in database
	 */
	@PostMapping("/add")
	public Response<?> addProduct(@RequestBody Product product) {
		logger.info("Adding product method ");
		try {
			return new Response<Product>(ResponseTypeEnum.SUCCESS, productService.addProduct(product));
		} catch (Exception e) {
			logger.error("New product not added to table" + e.getMessage());
			;
			return new Response<String>(ResponseTypeEnum.ERROR, e.getMessage());
		}

	}

	/**
	 * @return list of product without minimum price available in inventory
	 */
	@GetMapping("/")
	public List<ProductTitleAndDescriptionResponse> getAllProductForListing() {
		logger.info("Fetch Products available for Listing ");
		return productService.getPrductforListing();
	}
	
//	TODO can use more API for functinonality to perform other operation related with product 

}
