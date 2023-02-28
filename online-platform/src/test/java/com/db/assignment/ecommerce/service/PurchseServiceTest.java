package com.db.assignment.ecommerce.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.db.assignment.ecommerce.model.Product;
import com.db.assignment.ecommerce.model.PurchaseInfo;
import com.db.assignment.ecommerce.model.Status;
import com.db.assignment.ecommerce.repository.PurchaseInfoRepository;
import com.db.assignment.ecommerce.service.impl.PurchaseServiceImpl;

@SpringBootTest
public class PurchseServiceTest {

	@MockBean
	private PurchaseInfoRepository purchaseRepository;

	@Autowired
	private PurchaseServiceImpl purchaseServiceImpl;

	PurchaseInfo purchaseInfo;

	@Test
	public void testPurchaseRequest() {

		Product product = new Product(1l,"headphone", "Philips with 1", 1L, 8000.00, 2L, Status.AVAILABLE);

		PurchaseInfo purchaseInfo = new PurchaseInfo();
		purchaseInfo.setId(2l);
		purchaseInfo.setPrice(2000);
		purchaseInfo.setProduct(product);

		Mockito.when(purchaseRepository.save(purchaseInfo)).thenReturn(purchaseInfo);

		assertThat(purchaseServiceImpl.savePurchaseReq(purchaseInfo)).isEqualTo(purchaseInfo);

	}

}
