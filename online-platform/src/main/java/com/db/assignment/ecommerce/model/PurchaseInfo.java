package com.db.assignment.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PurchaseInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double price;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
	private Product product;
	

	public PurchaseInfo() {
		super();
	}

	public PurchaseInfo(long id, double price, Product product) {
		super();
		this.id = id;
		this.price = price;
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}
