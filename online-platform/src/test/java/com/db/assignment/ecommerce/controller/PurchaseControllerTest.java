package com.db.assignment.ecommerce.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.db.assignment.ecommerce.model.Product;
import com.db.assignment.ecommerce.model.Status;
import com.db.assignment.ecommerce.service.PurchaseService;
import com.db.assignment.ecommerce.service.ValidationService;

@WebMvcTest(PurchaseController.class)
public class PurchaseControllerTest {

	@MockBean
	ValidationService validationService;

	@MockBean
	PurchaseService purchaseService;

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void shouldReturnSuccessForPurchase() throws Exception {
		Product product = new Product(1l,"headphone", "Philips with 1", 1L, 8000.00, 2L, Status.AVAILABLE);
		when(validationService.validateProductByIdAndPrice(1L, 8000)).thenReturn((Optional.of(product)));
		mockMvc.perform(get("/api/purchase//validate/{id}/{price}", 1, 8000)).andExpect(status().isOk()).andDo(print());

	}
}
