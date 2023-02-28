package com.db.assignment.ecommerce.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductIdAndPriceResponse {

	private Long Id;
	private double price;

	public ProductIdAndPriceResponse() {
		super();
	}

	public ProductIdAndPriceResponse(Long id, double price) {
		super();
		Id = id;
		this.price = price;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
