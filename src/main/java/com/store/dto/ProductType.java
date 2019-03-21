package com.store.dto;

/**
 * The Enum ProductType.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
public enum ProductType {

    /** The a. */
    A(10),
    /** The b. */
    B(20),
    /** The c. */
    C(30),
    /** The other. */
    OTHER(0);

    /**
     * Instantiates a new product type.
     *
     * @param tax the tax
     */
    private ProductType(Integer tax) {
        this.taxValue = tax;
    }

    /** The tax value. */
    private Integer taxValue;

    public Integer getTaxValue() {
        return taxValue;
    }

}
