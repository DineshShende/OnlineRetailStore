package com.store.service;

import org.springframework.stereotype.Service;

import com.store.dto.AddProductRequest;
import com.store.dto.DetailedBillResponse;
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

    Bill intializeBill();

    Bill addProduct(Bill bill, Product product, Integer quantity);
    
    DetailedBillResponse geneateBill(Bill bill);
    
    DetailedBillResponse handleAddProductRequest(AddProductRequest addProductRequest);

}
