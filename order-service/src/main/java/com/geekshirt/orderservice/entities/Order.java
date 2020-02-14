package com.geekshirt.orderservice.entities;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Order {

	private String orderId;
	private String status;
	private String accountId;
	private Double totalAmount;
	private Double totalTax;
	private Date transactionDate;

}
