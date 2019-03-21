package com.store.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Bill.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
@Entity
@Table(name = "BILL")
public class Bill {

    /** The bill id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BILLID")
    private Long billId;

    /** The bill date. */
    @Column(name = "BILLDATE")
    private Date billDate;

    /** The bill item. */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "BILLITEM")
    private List<BillItem> billItem;

    /** The total amt. */
    @Column(name = "TOTALAMT")
    private Float totalAmt;

    /** The total tax. */
    @Column(name = "TOTALTAX")
    private Float totalTax;

    /** The gross total. */
    @Column(name = "GROSSTOTAL")
    private Float grossTotal;

    /**
     * Instantiates a new bill.
     */
    public Bill() {
    }

    /**
     * Instantiates a new bill.
     *
     * @param billDate the bill date
     */
    public Bill(Date billDate) {
        this.billDate = billDate;
    }

    /**
     * Instantiates a new bill.
     *
     * @param billId the bill id
     * @param billDate the bill date
     * @param billItem the bill item
     * @param totalAmt the total amt
     * @param totalTax the total tax
     * @param grossTotal the gross total
     */
    public Bill(Long billId, Date billDate, List<BillItem> billItem, Float totalAmt, Float totalTax, Float grossTotal) {
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

    public List<BillItem> getBillItem() {
        return billItem;
    }

    public void setBillItem(List<BillItem> billItem) {
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

    /**
     * {@inheritDoc}
     * <p>
     * This specific implementation .
     */
    @Override
    public String toString() {
        return "Bill [billId=" + billId + ", billDate=" + billDate + ", billItem=" + billItem + ", totalAmt="
                + totalAmt + ", totalTax=" + totalTax + ", grossTotal=" + grossTotal + "]";
    }

}
