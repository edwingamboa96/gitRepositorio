package com.geekshirt.orderservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekshirt.orderservice.client.CustomerServiceClient;
import com.geekshirt.orderservice.dao.ImplOrder;
import com.geekshirt.orderservice.dto.AccountDto;
import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.entities.Order;
import com.geekshirt.orderservice.exception.AccountNotFoundException;
import com.geekshirt.orderservice.util.ExceptionMessagesEnum;
import com.geekshirt.orderservice.util.OrderStatus;
import com.geekshirt.orderservice.util.OrderValidator;

@Service
public class OrderService {
	@Autowired
	private CustomerServiceClient customerClient;

	@Autowired
	private ImplOrder implOrder;

	public Order createOrder(OrderRequest orderRequest) {
		OrderValidator.validateOrder(orderRequest);
		AccountDto account = customerClient.findAccountById(orderRequest.getAccountId())
				.orElseThrow(() -> new AccountNotFoundException(ExceptionMessagesEnum.ACCOUNT_NOT_FOUND.getValue()));		
		Order newOrder = new Order();
		return implOrder.save(newOrder);
	}

	public List<Order> findAllOrders() {
		List<Order> orderList = new ArrayList<Order>();
		Order response = new Order();
		response.setAccountId("696396336");
		response.setOrderId("123456");
		response.setStatus(OrderStatus.PENDING);
		response.setTotalAmount(5.6);
		response.setTotalAmount(56.69);
		response.setTotalTax(5.6);
		response.setTransactionDate(new Date());

		Order order2 = new Order();
		order2.setAccountId("54156647");
		order2.setOrderId("44444");
		order2.setStatus(OrderStatus.SHIPPED);
		order2.setTotalAmount(3.6);
		order2.setTotalAmount(5.3);
		order2.setTotalTax(58.3);
		order2.setTransactionDate(new Date());

		orderList.add(order2);
		orderList.add(response);

		return orderList;

	}

	public Order findOrderById(String orderId) {
		Order response = new Order();
		response.setAccountId("432453");
		response.setOrderId(orderId);
		response.setStatus(OrderStatus.SHIPPED);
		response.setTotalAmount(3.6);
		response.setTotalAmount(5.3);
		response.setTotalTax(58.3);
		response.setTransactionDate(new Date());
		return response;

	}

}
