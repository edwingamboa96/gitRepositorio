package com.geekshirt.orderservice.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.geekshirt.orderservice.entities.Order;

@Repository
public class ImplOrder implements IorderDao {
	@PersistenceContext
	EntityManager entity;

	@Override
	public List<Order> findtAll() {
		
		return entity.createQuery("select o from Order o",Order.class).getResultList();
	}

	@Override
	public Optional<Order> findByOrderId(String orderId) {
	TypedQuery<Order>query=entity.createQuery("select o from Order o where Order.orderId=orderId",Order.class);
	query.setParameter("orderId", orderId);
		return Optional.ofNullable(query.getSingleResult());
	}

	@Override
	public Optional<Order> findById(Long id) {		
		return Optional.ofNullable(entity.find(Order.class, id));
	}

	@Override
	public Order save(Order order) {
		entity.persist(order);		
		return order;
	}

}
