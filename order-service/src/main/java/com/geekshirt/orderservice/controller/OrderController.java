package com.geekshirt.orderservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geekshirt.orderservice.dto.OrderResponse;

@RestController
public class OrderController {

	@GetMapping(value = "order")
	public ResponseEntity<List<OrderResponse>> finAll() {
		List<OrderResponse> orderList = new ArrayList<OrderResponse>();
		
		return new ResponseEntity<>(orderList, HttpStatus.OK);
        
		
		
	}

}
