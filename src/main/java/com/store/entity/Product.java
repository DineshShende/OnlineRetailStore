package com.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Product.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
@Entity
@Table(name = "PRODUCT")
public class Product {

    /** The product id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTID")
    private Long productId;

    /** The scan code id. */
    @Column(name = "SCANCODEID", unique = true)
    private String scanCodeId;

    /** The cost. */
    @Column(name = "COST")
    private Float cost;

    /** The product name. */
    @Column(name = "PRODUCTNAME")
    private String productName;

    /** The product type. */
    @Column(name = "PRODUCTTYPE")
    private String productType;

    /**
     * Instantiates a new product.
     */
    public Product() {
    }

    /**
     * Instantiates a new product.
     *
     * @param productId the product id
     * @param scanCodeId the scan code id
     * @param cost the cost
     * @param productName the product name
     * @param productType the product type
     */
    public Product(Long productId, String scanCodeId, Float cost, String productName, String productType) {
        super();
        this.productId = productId;
        this.scanCodeId = scanCodeId;
        this.cost = cost;
        this.productName = productName;
        this.productType = productType;
    }

    /**
     * Instantiates a new product.
     *
     * @param scanCodeId the scan code id
     * @param cost the cost
     * @param productName the product name
     * @param productType the product type
     */
    public Product(String scanCodeId, Float cost, String productName, String productType) {
        this.scanCodeId = scanCodeId;
        this.cost = cost;
        this.productName = productName;
        this.productType = productType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getScanCodeId() {
        return scanCodeId;
    }

    public void setScanCodeId(String scanCodeId) {
        this.scanCodeId = scanCodeId;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * {@inheritDoc}
     * <p>
     * This specific implementation .
     */
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", scanCodeId=" + scanCodeId + ", cost=" + cost + ", productName="
                + productName + ", productType=" + productType + "]";
    }

}
