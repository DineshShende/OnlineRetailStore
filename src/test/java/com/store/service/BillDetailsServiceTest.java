package com.store.service;

import static com.store.datafixture.ProductDataFixture.standardProductA;
import static com.store.datafixture.ProductDataFixture.standardProductB;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.store.dto.DetailedBillResponse;
import com.store.entity.Bill;
import com.store.entity.Product;
import com.store.repository.BillItemRepository;
import com.store.repository.BillRepository;
import com.store.repository.ProductRepository;

/**
 * The Class BillDetailsServiceTest.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BillDetailsServiceTest {

    /** The bill details service. */
    @Autowired
    BillDetailsService billDetailsService;

    /** The product repository. */
    @Autowired
    ProductRepository productRepository;

    /** The bill repository. */
    @Autowired
    BillRepository billRepository;

    /** The bill item repository. */
    @Autowired
    BillItemRepository billItemRepository;

    /** The product A. */
    Product productA = null;

    /** The product B. */
    Product productB = null;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {

        billRepository.deleteAll();
        productRepository.deleteAll();

        productA = productRepository.save(standardProductA());
        productB = productRepository.save(standardProductB());

    }

    /**
     * Clean up.
     */
    @After
    public void cleanUp() {

        billItemRepository.deleteAll();
        billRepository.deleteAll();
        productRepository.deleteAll();

    }

    /**
     * Context loads.
     */
    @Test
    public void contextLoads() {
    }

    /**
     * Initialize bill test.
     */
    @Test
    public void initializeBillTest() {

        Bill initializedBill = billDetailsService.intializeBill();

        assertNotNull(initializedBill.getBillId());
    }

    /**
     * Adds the product to bill test.
     */
    @Test
    public void addProductToBillTest() {

        Bill initializedBill = billDetailsService.intializeBill();

        Bill updatedBill = billDetailsService.addProduct(initializedBill, productA, 1);

        assertNotNull(updatedBill.getBillId());
    }

    /**
     * Adds the same type of product to bill test.
     */
    @Test
    public void addSameTypeOfProductToBillTest() {

        Bill initializedBill = billDetailsService.intializeBill();

        Bill updatedBill = billDetailsService.addProduct(initializedBill, productA, 1);

        updatedBill = billDetailsService.addProduct(initializedBill, productA, 2);

        assertNotNull(updatedBill.getBillId());
    }

    /**
     * Adds the diff type of product to bill test.
     */
    @Test
    public void addDiffTypeOfProductToBillTest() {

        Bill initializedBill = billDetailsService.intializeBill();

        Bill updatedBill = billDetailsService.addProduct(initializedBill, productA, 1);

        updatedBill = billDetailsService.addProduct(initializedBill, productB, 2);
     
        assertNotNull(updatedBill.getBillId());
    }
    
    @Test
    public void DetailedBillResponseTest() {

        Bill initializedBill = billDetailsService.intializeBill();

        Bill updatedBill = billDetailsService.addProduct(initializedBill, productA, 1);

        updatedBill = billDetailsService.addProduct(initializedBill, productB, 2);
        
        DetailedBillResponse detailedBillResponse=billDetailsService.geneateBill(updatedBill); 
     
        System.out.println(detailedBillResponse);
        
        assertNotNull(updatedBill.getBillId());
    }
}
