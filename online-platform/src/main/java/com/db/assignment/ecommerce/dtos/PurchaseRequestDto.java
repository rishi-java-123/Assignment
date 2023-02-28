package com.db.assignment.ecommerce.dtos;

public class PurchaseRequestDto {

	private Double puchseRequestAmount;
	

	public PurchaseRequestDto(Double puchseRequestAmount) {
		super();
		this.puchseRequestAmount = puchseRequestAmount;
	}

	
	public PurchaseRequestDto() {
		super();
		
	}


	public Double getPuchseRequestAmount() {
		return puchseRequestAmount;
	}

	public void setPuchseRequestAmount(Double puchseRequestAmount) {
		this.puchseRequestAmount = puchseRequestAmount;
	}


	@Override
	public String toString() {
		return "PurchaseRequestDto [puchseRequestAmount=" + puchseRequestAmount + "]";
	}
	
	
	
}
