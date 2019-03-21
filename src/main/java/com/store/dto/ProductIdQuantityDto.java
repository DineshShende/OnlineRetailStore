package com.store.dto;

public class ProductIdQuantityDto {
	
	private Long productId;
	
	private Integer quantity;

	public ProductIdQuantityDto() {
		super();
	}

	public ProductIdQuantityDto(Long productId, Integer quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductIdQuantityDto [productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	

}
