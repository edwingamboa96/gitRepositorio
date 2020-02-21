package com.geekshirt.orderservice.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekshirt.orderservice.client.CustomerServiceClient;
import com.geekshirt.orderservice.dao.ImplOrder;
import com.geekshirt.orderservice.dto.AccountDto;
import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.entities.Order;
import com.geekshirt.orderservice.entities.OrderDetail;
import com.geekshirt.orderservice.exception.AccountNotFoundException;
import com.geekshirt.orderservice.exception.OrderNotFoundException;
import com.geekshirt.orderservice.util.ConstantsCustom;
import com.geekshirt.orderservice.util.ExceptionMessagesEnum;
import com.geekshirt.orderservice.util.OrderStatus;
import com.geekshirt.orderservice.util.OrderValidator;

@Service
public class OrderService {
	@Autowired
	private CustomerServiceClient customerClient;

	@Autowired
	private ImplOrder implOrder;
     
	@Transactional
	public Order createOrder(OrderRequest orderRequest) {
		OrderValidator.validateOrder(orderRequest);
		AccountDto account = customerClient.findAccountById(orderRequest.getAccountId())
				.orElseThrow(() -> new AccountNotFoundException(ExceptionMessagesEnum.ACCOUNT_NOT_FOUND.getValue()));
		Order newOrder = initOrder(orderRequest);
		return implOrder.save(newOrder);
	}

	private Order initOrder(OrderRequest orderRequest) {
		Order orderObj = new Order();
		orderObj.setOrderId(UUID.randomUUID().toString());
		orderObj.setAccountId(orderRequest.getAccountId());
		orderObj.setStatus(OrderStatus.PENDING);
		List<OrderDetail> orderDetails = orderRequest.getItems().stream()
				.map(order -> OrderDetail.builder()
						.price(order.getPrice())
						.quantity(order.getQuantity())
						.upc(order.getUpc())
						.tax(order.getPrice() * order.getQuantity() * ConstantsCustom.TAX_IMPORTE)
						.order(orderObj).build())
				.collect(Collectors.toList());

		orderObj.setDetails(orderDetails);
		orderObj.setTotalAmount(orderDetails.stream().mapToDouble(OrderDetail::getPrice).sum());
		orderObj.setTotalTax(orderObj.getTotalAmount() *ConstantsCustom.TAX_IMPORTE);
		orderObj.setTransactionDate(new Date());
		return orderObj;
	}

	public List<Order> findAllOrders() {
		return implOrder.findtAll();

	}

	public Order findOrderById(String orderId) {
		return implOrder.findByOrderId(orderId)
				.orElseThrow(() -> new OrderNotFoundException(ExceptionMessagesEnum.ACCOUNT_NOT_FOUND.getValue()));

	}

	public Order findById(Long orderId) {
		return implOrder.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException(ExceptionMessagesEnum.ACCOUNT_NOT_FOUND.getValue()));

	}

}
