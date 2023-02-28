package com.db.assignment.ecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.assignment.ecommerce.dtos.PurchaseMessageDto;
import com.db.assignment.ecommerce.dtos.PurchaseMessageTypeEnum;
import com.db.assignment.ecommerce.exception.ProductNotFoundException;
import com.db.assignment.ecommerce.model.Product;
import com.db.assignment.ecommerce.model.PurchaseInfo;
import com.db.assignment.ecommerce.service.PurchaseService;
import com.db.assignment.ecommerce.service.ValidationService;
import com.db.assignment.ecommerce.util.Helper;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
	Logger logger = LoggerFactory.getLogger(PurchaseController.class);

	@Autowired
	ValidationService validationService;

	@Autowired
	PurchaseService purchaseService;

	/**
	 * @param Id of product for purchase request
	 * @param price suggested by buyer
	 * @return Purchase message to show either it is success or fail
	 */
	@GetMapping("/validate/{id}/{price}")
	public PurchaseMessageDto<?> purchase(@PathVariable Long id, @PathVariable double price) {
		logger.info("Purchase Request to Buy the product");
		Optional<Product> products = validationService.validateProductByIdAndPrice(id, price);
		if (products.isPresent()) {
			PurchaseMessageDto<?> validatedPurchaseReq = Helper.validatePurchasePrice(price, products);
			if (validatedPurchaseReq.getMessageType() != null && validatedPurchaseReq.getMessageType()
					.equals(PurchaseMessageTypeEnum.PURCHASED_REQUEST_SUCCESS)) {
				Product product = products.get();
				PurchaseInfo info = new PurchaseInfo();
				info.setPrice(price);
				info.setProduct(product);
				purchaseService.savePurchaseReq(info);
			}
			return validatedPurchaseReq;
		} else {
			logger.error("Can not find the specified product:"+id);
			throw new ProductNotFoundException("product not found with Id  :" + id);
		}
	}

}
