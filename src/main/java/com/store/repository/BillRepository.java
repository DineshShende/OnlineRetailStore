package com.store.repository;

import org.springframework.data.repository.CrudRepository;

import com.store.entity.Bill;

/**
 * The Interface BillRepository.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
public interface BillRepository extends CrudRepository<Bill, Long> {

}
