package com.store.dto;

import java.util.Date;
import java.util.List;

public class DetailedBillResponse {
	
	private Long billId;

    private Date billDate;

    private List<BillItemDetails> billItem;

    private Float totalAmt;

    private Float totalTax;

    private Float grossTotal;

	public DetailedBillResponse() {
		super();
	}

	public DetailedBillResponse(Long billId, Date billDate, List<BillItemDetails> billItem, Float totalAmt,
			Float totalTax, Float grossTotal) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.billItem = billItem;
		this.totalAmt = totalAmt;
		this.totalTax = totalTax;
		this.grossTotal = grossTotal;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public List<BillItemDetails> getBillItem() {
		return billItem;
	}

	public void setBillItem(List<BillItemDetails> billItem) {
		this.billItem = billItem;
	}

	public Float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Float totalAmt) {
		this.totalAmt = totalAmt;
	}

	public Float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(Float totalTax) {
		this.totalTax = totalTax;
	}

	public Float getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(Float grossTotal) {
		this.grossTotal = grossTotal;
	}

	@Override
	public String toString() {
		return "DetailedBillResponse [billId=" + billId + ", billDate=" + billDate + ", billItem=" + billItem
				+ ", totalAmt=" + totalAmt + ", totalTax=" + totalTax + ", grossTotal=" + grossTotal + "]";
	}
    
    

}
