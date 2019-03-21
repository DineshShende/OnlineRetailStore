package com.store.repository;

import org.springframework.data.repository.CrudRepository;

import com.store.entity.BillItem;

/**
 * The Interface BillItemRepository.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
public interface BillItemRepository extends CrudRepository<BillItem, Long> {

}
