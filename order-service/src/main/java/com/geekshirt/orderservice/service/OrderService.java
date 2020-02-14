package com.geekshirt.orderservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.entities.Order;

@Service
public class OrderService {
	public Order createOrder(OrderRequest orderRequest) {

		Order order = new Order();
		order.setAccountId("696396336");
		order.setOrderId("123456");
		order.setStatus("Pending");
		order.setTotalAmount(5.6);
		order.setTotalAmount(56.69);
		order.setTotalTax(5.6);
		order.setTransactionDate(new Date());

		return order;

	}

	public List<Order> findAllOrders() {
		List<Order> orderList = new ArrayList<Order>();
		Order order = new Order();
		order.setAccountId("696396336");
		order.setOrderId("123456");
		order.setStatus("Pending");
		order.setTotalAmount(5.6);
		order.setTotalAmount(56.69);
		order.setTotalTax(5.6);
		order.setTransactionDate(new Date());

		Order order2 = new Order();
		order2.setAccountId("54156647");
		order2.setOrderId("44444");
		order2.setStatus("OK");
		order2.setTotalAmount(3.6);
		order2.setTotalAmount(5.3);
		order2.setTotalTax(58.3);
		order2.setTransactionDate(new Date());

		orderList.add(order2);
		orderList.add(order);

		return orderList;

	}

	public Order findOrderById(String orderId) {
		Order order2 = new Order();
		order2.setAccountId("432453");
		order2.setOrderId(orderId);
		order2.setStatus("OK");
		order2.setTotalAmount(3.6);
		order2.setTotalAmount(5.3);
		order2.setTotalTax(58.3);
		order2.setTransactionDate(new Date());
		return order2;

	}

}
