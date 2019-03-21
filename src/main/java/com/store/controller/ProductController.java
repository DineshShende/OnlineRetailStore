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
    public ResponseEntity<Product> getByScanId(@PathVariable Long scanId) {
        Product product = productService.getByScanId(scanId);

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
