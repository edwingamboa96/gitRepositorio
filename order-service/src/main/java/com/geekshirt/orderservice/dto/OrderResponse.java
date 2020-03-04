package com.geekshirt.orderservice.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
	//private Long id;
	private String orderId;
	private String status;
	private String accountId;
	private Double totalAmount;
	private Double totalTax;
	private Date transactionDate;
	List<OrderDetailResponse>details;

}
