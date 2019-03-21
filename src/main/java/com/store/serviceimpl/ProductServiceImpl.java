package com.store.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.store.entity.Product;
import com.store.repository.ProductRepository;
import com.store.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product getByScanId(String scanCodeId) {

		Product fetchedProduct=productRepository.findByScanCodeId(scanCodeId);
		
		return fetchedProduct;
	}

}
