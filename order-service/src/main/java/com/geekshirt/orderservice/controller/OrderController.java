package com.geekshirt.orderservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geekshirt.orderservice.dto.OrderResponse;

@RestController
public class OrderController {

	@GetMapping(value = "order")
	public ResponseEntity<List<OrderResponse>> finAll() {
		List<OrderResponse> orderList = new ArrayList<OrderResponse>();
		OrderResponse order=new OrderResponse();
		order.setAccountId("696396336");
		order.setOrderId("123456");
		order.setStatus("Pending");
		order.setTotalAmount(5.6);
		order.setTotalAmount(56.69);
		order.setTotalTax(5.6);
		order.setTransactionDate(new Date());
		
		OrderResponse order2=new OrderResponse();
		order2.setAccountId("54156647");
		order2.setOrderId("44444");
		order2.setStatus("OK");
		order2.setTotalAmount(3.6);
		order2.setTotalAmount(5.3);
		order2.setTotalTax(58.3);
		order2.setTransactionDate(new Date());
		
		orderList.add(order2);
		orderList.add(order);
		
		return new ResponseEntity<>(orderList, HttpStatus.OK);     
	}
	
	@GetMapping(value ="order/{orderId}" )
	public ResponseEntity<OrderResponse>getByID(@PathVariable String orderId){
		OrderResponse order4=new OrderResponse();
		order4.setAccountId("432453");
		order4.setOrderId(orderId);
		order4.setStatus("kmlkkl");
		order4.setTotalAmount(3.6);
		order4.setTotalAmount(5.3);
		order4.setTotalTax(58.3);
		order4.setTransactionDate(new Date());		
		
		return  new ResponseEntity<>(order4,HttpStatus.OK);
		
		
	}
	
	@PostMapping(value = "order/create")
	public ResponseEntity<OrderResponse>createOrder(@RequestBody OrderRequest payload){
		OrderResponse order2=new OrderResponse();
		order2.setAccountId(payload.getAccountId());
		order2.setOrderId("44444");
		order2.setStatus("OK");
		order2.setTotalAmount(3.6);
		order2.setTotalAmount(5.3);
		order2.setTotalTax(58.3);
		order2.setTransactionDate(new Date());	
		
		return  new ResponseEntity<>(order2,HttpStatus.OK);
	}
	

}
