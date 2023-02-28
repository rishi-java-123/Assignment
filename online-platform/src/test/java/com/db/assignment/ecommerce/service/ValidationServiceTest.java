package com.db.assignment.ecommerce.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.db.assignment.ecommerce.model.Product;
import com.db.assignment.ecommerce.model.PurchaseInfo;
import com.db.assignment.ecommerce.model.Status;
import com.db.assignment.ecommerce.repository.ProductRepository;
import com.db.assignment.ecommerce.repository.PurchaseInfoRepository;
import com.db.assignment.ecommerce.service.impl.ValidationServiceImpl;

@SpringBootTest
public class ValidationServiceTest {

	@MockBean
	ProductRepository productRepository;
	@MockBean
	PurchaseInfoRepository purchaseInforepo;

	@Autowired
	private ValidationServiceImpl validationServiceImpl;

	PurchaseInfo purchaseInfo;

	@Test
	public void testValidateProduct() {

		Product product = new Product(1l, "headphone", "Philips with 1", 1L, 8000.00, 2L, Status.AVAILABLE);

		PurchaseInfo purchaseInfo = new PurchaseInfo();
		purchaseInfo.setId(3l);
		purchaseInfo.setPrice(2000);
		purchaseInfo.setProduct(product);

		Mockito.when(productRepository.findById(1l)).thenReturn(Optional.of(product));

		assertThat(validationServiceImpl.validateProductByIdAndPrice(1L, 2000)).isEqualTo(Optional.of(product));

	}
}
