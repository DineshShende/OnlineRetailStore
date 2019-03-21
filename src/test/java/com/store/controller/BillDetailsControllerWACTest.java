package com.store.controller;

import static com.store.datafixture.ProductDataFixture.*;
import static com.store.datafixture.ProductDataFixture.standardProductAWithId;
import static com.store.datafixture.ProductDataFixture.standardProductB;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.store.dto.AddProductRequest;
import com.store.dto.ProductIdQuantityDto;
import com.store.entity.Bill;
import com.store.entity.Product;
import com.store.repository.BillItemRepository;
import com.store.repository.BillRepository;
import com.store.repository.ProductRepository;
import com.store.service.BillDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BillDetailsControllerWACTest {

	@Autowired
    private MockMvc mockMvc;

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

	
    @Test
    public void billInit() throws Exception {
        this.mockMvc.perform(get("/bill/init")).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.billId").exists());
    }
    
    @Test
    public void addProduct() throws Exception {
        
    	Bill bill=  billDetailsService.intializeBill();
    	
    	String jsonContent=addProductJson(new AddProductRequest(bill.getBillId(), Arrays.asList(new ProductIdQuantityDto(productA.getProductId(),2))));
    	
    	
        this.mockMvc.perform(post("/bill/addProduct")
                .contentType("application/json;charset=UTF-8")
                .content(jsonContent))
                .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.billId").exists())
        .andExpect(jsonPath("$.billItem.[0].productName").value(productA.getProductName()));
    }
	
}
