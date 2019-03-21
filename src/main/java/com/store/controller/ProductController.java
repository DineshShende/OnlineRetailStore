package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.Product;
import com.store.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/getByScanId/{scanId}")
    public ResponseEntity<Product> getByScanId(@PathVariable String scanId) {

    	if(scanId==null)
    		return new ResponseEntity<Product>(HttpStatus.NOT_ACCEPTABLE);
    	
    	Product product = productService.getByScanId(scanId);
    	
    	if(product==null)
    		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    
    
}
