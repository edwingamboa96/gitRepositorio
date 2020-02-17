package com.geekshirt.orderservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@Configuration
@PropertySource({ "classpath:application.properties" })

public class OrderServiceConfig {
	@Value("${customerservice.url}")

	private String customerServiceUrl;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
