package com.store.controller;

import static com.store.datafixture.ProductDataFixture.standardProductAWithId;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import com.store.service.ProductService;

public class ProductControllerMockTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    /** The mock mvc. */
    private MockMvc mockMvc;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = standaloneSetup(productController).build();

    }

    /**
     * Get By ScanId Test with expected result found.
     * 
     * @throws Exception
     */
    @Test
    public void getByScanIdTestFound() throws Exception {

        when(productService.getByScanId("1")).thenReturn(standardProductAWithId());

        this.mockMvc.perform(get("/product/getByScanId/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.scanCodeId").value(standardProductAWithId().getScanCodeId()))
                .andExpect(jsonPath("$.productName").value(standardProductAWithId().getProductName()))
                .andExpect(jsonPath("$.productType").value(standardProductAWithId().getProductType()));

    }
    
    /**
     * Get By ScanId Test with expectation of result not found.
     * 
     * @throws Exception
     */
    @Test
    public void getByScanIdTestNotFound() throws Exception {

        when(productService.getByScanId("1")).thenReturn(null);

        this.mockMvc.perform(get("/product/getByScanId/1")).andDo(print()).andExpect(status().isNoContent());

    }
    

}
