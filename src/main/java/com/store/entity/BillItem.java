package com.store.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class BillItem.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
@Entity
@Table(name = "BILLITEM")
public class BillItem {

    /** The bill item id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BILLITEMID")
    private Long billItemId;

    /** The product id. */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCTID")
    private Product productId;

    // /** The product name. */
    // @Column(name = "PRODUCTNAME")
    // private String productName;

    /** The qunatity. */
    @Column(name = "QUANTITY")
    private Integer quantity;

    /** The bill id. */
    @OneToOne
    private Bill billId;

    /**
     * Instantiates a new bill item.
     */
    public BillItem() {
    }

    /**
     * Instantiates a new bill item.
     *
     * @param billItemId the bill item id
     * @param productId the product id
     * @param productName the product name
     * @param qunatity the qunatity
     * @param billId the bill id
     */
    public BillItem(Long billItemId, Product productId, Integer quantity, Bill billId) {
        super();
        this.billItemId = billItemId;
        this.productId = productId;
        // this.productName = productName;
        this.quantity = quantity;
        this.billId = billId;
    }

    /**
     * Instantiates a new bill item.
     *
     * @param productId the product id
     * @param qunatity the qunatity
     * @param billId the bill id
     */
    public BillItem(Product productId, Integer quantity, Bill billId) {
        this.productId = productId;
        this.quantity = quantity;
        this.billId = billId;
    }

    public Long getBillItemId() {
        return billItemId;
    }

    public void setBillItemId(Long billItemId) {
        this.billItemId = billItemId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This specific implementation .
     */
    @Override
    public String toString() {
        return "BillItem [billItemId=" + billItemId + ", productId=" + productId + ", quantity=" + quantity + "]";
    }

}
