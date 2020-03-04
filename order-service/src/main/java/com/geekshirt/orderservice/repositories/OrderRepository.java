package com.geekshirt.orderservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geekshirt.orderservice.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findOrdersByAccountId(String id);
	public Order findOrderByOrderId(String OrderId);
}
