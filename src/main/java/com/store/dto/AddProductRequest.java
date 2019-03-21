package com.store.dto;

import java.util.List;

public class AddProductRequest {
	
	private Long billId;

	private List<ProductIdQuantityDto> productIdWithQuantity;
	
	
	public AddProductRequest() {
		super();
	}

	

	public AddProductRequest(Long billId, List<ProductIdQuantityDto> productIdWithQuantity) {
		super();
		this.billId = billId;
		this.productIdWithQuantity = productIdWithQuantity;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public List<ProductIdQuantityDto> getProductIdWithQuantity() {
		return productIdWithQuantity;
	}

	public void setProductIdWithQuantity(List<ProductIdQuantityDto> productIdWithQuantity) {
		this.productIdWithQuantity = productIdWithQuantity;
	}



	@Override
	public String toString() {
		return "AddProductRequest [billId=" + billId + ", productIdWithQuantity=" + productIdWithQuantity + "]";
	}

	
		
	
}
