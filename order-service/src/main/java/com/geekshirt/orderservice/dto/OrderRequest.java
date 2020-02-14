package com.geekshirt.orderservice.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(description = "Class representing an order to processed")
public class OrderRequest {
	@NotNull
	@NotBlank
	@ApiModelProperty(notes = "Acount Id",example = "123456789123",required = true)
	private String accountId;
	
	@ApiModelProperty(notes="Items include in the order",required=false)
	private List<LineItem>items;

}
