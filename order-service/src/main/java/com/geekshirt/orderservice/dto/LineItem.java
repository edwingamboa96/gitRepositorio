package com.geekshirt.orderservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;




@Data
@AllArgsConstructor
@ApiModel(description = "Class that represents an item included in the order")
public class LineItem {
	
	@ApiModelProperty(notes ="Upc(Universal Product Code),length 12 Digits" ,example="123698567895",required = true,position=0)
	private String upc;
	@ApiModelProperty(notes ="Quantity" ,example="20",required = true,position=1)
	private int quantity;
	@ApiModelProperty(notes ="Price" ,example="10.00",required = true,position=2)
	private double price;
	

}
