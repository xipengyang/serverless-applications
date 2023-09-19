package com.davidyang.coffeeshop.orderpersistence.repository;

import com.davidyang.coffeeshop.orderpersistence.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends CrudRepository<Order, Long>, PagingAndSortingRepository<Order, Long> {
}
