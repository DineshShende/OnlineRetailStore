package com.store.service;

import org.springframework.stereotype.Service;

import com.store.entity.Product;

/**
 * The Interface ProductService.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
@Service
public interface ProductService {

    /**
     * Gets the by scan id.
     *
     * @param scanId the scan id
     * @return the by scan id
     */
    Product getByScanId(String scanId);

}
