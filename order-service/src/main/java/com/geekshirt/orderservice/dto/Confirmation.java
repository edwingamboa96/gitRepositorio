package com.geekshirt.orderservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Confirmation {
	private String orderId;
	private String accountId;
	private String transactionId;
	private String transactionStatus;
	private String transactionAuthCode;
	private Date transactionDate;

}
