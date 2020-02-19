package com.geekshirt.orderservice.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "QUANTY")
	private Integer quanty;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "TAX")
	private Double tax;

	@Column(name = "UPC")
	private String upc;

	@ManyToOne(cascade = CascadeType.ALL)
	private Order order;
}
