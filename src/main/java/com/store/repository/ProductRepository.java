package com.store.repository;

import org.springframework.data.repository.CrudRepository;

import com.store.entity.Product;

/**
 * The Interface ProductRepository.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

}
