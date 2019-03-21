package com.store.dto;

public class BillItemDetails {

	private String productName;
	
	private Integer quantity;
	
	private Float itemTotal;
	
	private Float itemTax;
	
	private Float itemGrossTotal;

	
	
	public BillItemDetails() {
		super();
	}



	public BillItemDetails(String productName, Integer quantity, Float itemTotal, Float itemTax, Float itemGrossTotal) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
		this.itemTax = itemTax;
		this.itemGrossTotal = itemGrossTotal;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Float getItemTotal() {
		return itemTotal;
	}



	public void setItemTotal(Float itemTotal) {
		this.itemTotal = itemTotal;
	}



	public Float getItemTax() {
		return itemTax;
	}



	public void setItemTax(Float itemTax) {
		this.itemTax = itemTax;
	}



	public Float getItemGrossTotal() {
		return itemGrossTotal;
	}



	public void setItemGrossTotal(Float itemGrossTotal) {
		this.itemGrossTotal = itemGrossTotal;
	}



	@Override
	public String toString() {
		return "BillItemDetails [productName=" + productName + ", quantity=" + quantity + ", itemTotal=" + itemTotal
				+ ", itemTax=" + itemTax + ", itemGrossTotal=" + itemGrossTotal + "]";
	}
	
	
	
	
}
