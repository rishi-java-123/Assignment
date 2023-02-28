package com.db.assignment.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.assignment.ecommerce.dtos.PurchaseMessageDto;
import com.db.assignment.ecommerce.dtos.PurchaseMessageTypeEnum;
import com.db.assignment.ecommerce.model.Product;
import com.db.assignment.ecommerce.service.ProductService;
import com.db.assignment.ecommerce.service.ValidationService;
import com.db.assignment.ecommerce.util.Helper;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

	@Autowired
	ValidationService validationService;

	@GetMapping("/{id}/{price}")
	public PurchaseMessageDto<?> purchase(@PathVariable Long id, @PathVariable double price) {

		Optional<Product> products = validationService.validateProductByIdAndPrice(id, price);
		if (products.isPresent()) {
			Product product = products.get();
			int result = Helper.comapreDobleValues(price,product.getMinimumPrice() );
			System.out.println(result);
			if (result == 0) {
				return new PurchaseMessageDto<String>(product.getTitle(),
						PurchaseMessageTypeEnum.PURCHASED_REQUEST_SUCCESS);
			} else if (result > 0) {
				return new PurchaseMessageDto<String>(product.getTitle(),
						PurchaseMessageTypeEnum.PURCHASED_REQUEST_SUCCESS);
			} else {
				return new PurchaseMessageDto<String>(product.getTitle(),
						PurchaseMessageTypeEnum.PURCHASED_REQUEST_FAIL);
			}

		}else {
			throw new RuntimeException("product not found");
		}
	}

}
