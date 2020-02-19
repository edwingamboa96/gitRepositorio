package com.geekshirt.orderservice.dao;

import java.util.List;
import java.util.Optional;

import com.geekshirt.orderservice.entities.Order;

public interface IorderDao {

	public List<Order> findtAll();
	Optional<Order> findByOrderId(String orderId);
	Optional<Order> findById(Long id);
	Order save(Order order);

}
