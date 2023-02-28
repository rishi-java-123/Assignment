package com.db.assignment.ecommerce.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.db.assignment.ecommerce.dtos.ProductTitleAndDescriptionResponse;
import com.db.assignment.ecommerce.model.Product;
import com.db.assignment.ecommerce.model.Status;
import com.db.assignment.ecommerce.repository.ProductRepository;
import com.db.assignment.ecommerce.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {


	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;
	  
	  @MockBean
	  private ProductRepository productRepository;
	  
	  @MockBean
	  private ProductService productService;
	  
	  @Test
	  void shouldAddProduct() throws Exception {
	    Product product = new  Product(1l,"headphone","Philips with 1",1L, 8000.00, 2L,Status.AVAILABLE);

	    mockMvc.perform(post("/api/product/add").contentType(MediaType.APPLICATION_JSON)
	        .content(objectMapper.writeValueAsString(product)))
	        .andExpect(status().isOk())
	        .andDo(print());
	  }
	  
	  
	  @Test
	  void shouldReturnListOfProducts() throws Exception {
	    List<ProductTitleAndDescriptionResponse> products = new ArrayList<>(
	        Arrays.asList(new ProductTitleAndDescriptionResponse("Laptop","HP Laptop"),
	            new ProductTitleAndDescriptionResponse("HeadPhone","Sony"),
	            new ProductTitleAndDescriptionResponse("Mobile","Z")));

	    when(productService.getPrductforListing()).thenReturn(products);
	    mockMvc.perform(get("/api/product/"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.size()").value(products.size()))
	        .andDo(print());
	  }

}
