package com.db.assignment.ecommerce.util;

import java.util.Optional;

import com.db.assignment.ecommerce.dtos.PurchaseMessageDto;
import com.db.assignment.ecommerce.dtos.PurchaseMessageTypeEnum;
import com.db.assignment.ecommerce.model.Product;

public class Helper {

	private Helper() {

	}

	public static int comapreDobleValues(double d1, double d2) {
		int result = Double.compare(d1, d2);
		return result;

	}
	
	
	public static PurchaseMessageDto<?> validatePurchasePrice(double price, Optional<Product> products) {
		Product product = products.get();
		int result = Helper.comapreDobleValues(price,product.getMinimumPrice() );
		if (result == 0) {
			return new PurchaseMessageDto<String>(product.getTitle(),
					PurchaseMessageTypeEnum.PURCHASED_REQUEST_FAIL);
		} else if (result > 0) {
			return new PurchaseMessageDto<String>(product.getTitle(),
					PurchaseMessageTypeEnum.PURCHASED_REQUEST_SUCCESS);
		} else {
			return new PurchaseMessageDto<String>(product.getTitle(),
					PurchaseMessageTypeEnum.PURCHASED_REQUEST_FAIL);
		}
	}

}
