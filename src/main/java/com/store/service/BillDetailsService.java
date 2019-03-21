package com.store.service;

import org.springframework.stereotype.Service;

import com.store.entity.Bill;
import com.store.entity.Product;

/**
 * The Interface BillDetailsService.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
@Service
public interface BillDetailsService {

    /**
     * Intialize bill.
     *
     * @return the bill
     */
    Bill intializeBill();

    Bill addProduct(Bill bill, Product product, Integer quantity);

}
