package com.geekshirt.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geekshirt.orderservice.dto.OrderRequest;
import com.geekshirt.orderservice.dto.OrderResponse;
import com.geekshirt.orderservice.entities.Order;
import com.geekshirt.orderservice.service.OrderService;
import com.geekshirt.orderservice.util.EntityDtoConverter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private EntityDtoConverter converter;
	

	@ApiOperation(value = "Retrive all existed orders", notes = "this operation return all stored orders")
	@GetMapping(value = "order")
	public ResponseEntity<List<OrderResponse>> finAll() {		
		List<Order> orderList =orderService.findAllOrders();
		return new ResponseEntity<>(converter.convertEntityToDto(orderList), HttpStatus.OK);
	}


	@ApiOperation(value = "Retrive an order based on ID ", notes = "this operation return an order using its Id")
	@GetMapping(value = "order/{orderId}")
	public ResponseEntity<OrderResponse> getByID(@PathVariable String orderId) {
	   Order order=orderService.findOrderById(orderId); 	  
	   return new ResponseEntity<>(converter.convertEntityToDto(order), HttpStatus.OK);

	}
	
	@ApiOperation(value = "Retrive an order based on ID ", notes = "this operation return an order using its Id")
	@GetMapping(value = "order/generated/{orderId}")
	public ResponseEntity<OrderResponse> fiendByGeneratedId(@PathVariable long orderId) {
	   Order order=orderService.findById(orderId); 	  
	   return new ResponseEntity<>(converter.convertEntityToDto(order), HttpStatus.OK);

	}

	@ApiOperation(value = "Create an order", notes = "this operation create a new order")
	@PostMapping(value = "order/create")
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest payload) {
		Order order =orderService.createOrder(payload);	
		return new ResponseEntity<>(converter.convertEntityToDto(order), HttpStatus.CREATED);
	}

}
