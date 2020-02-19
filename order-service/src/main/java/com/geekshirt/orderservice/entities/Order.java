package com.geekshirt.orderservice.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.geekshirt.orderservice.util.OrderStatus;

import lombok.Data;

@Data

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ORDER_ID")
	private String orderId;
	
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)	
	private OrderStatus status;
	
	@Column(name = "ACCOUNT_ID")
	private String accountId;
	
	@Column(name = "TOTAL_AMOUNT")
	private Double totalAmount;

	@Column(name = "TOTAL_TAX")
	private Double totalTax;
	
	@Column(name = "TRANSACCIONAL_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy ="order" )
	private List<OrderDetail>details;

}
