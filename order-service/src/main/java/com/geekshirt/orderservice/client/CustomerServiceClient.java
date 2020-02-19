package com.geekshirt.orderservice.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.geekshirt.orderservice.config.OrderServiceConfig;
import com.geekshirt.orderservice.dto.AccountDto;
import com.geekshirt.orderservice.dto.AddressDto;
import com.geekshirt.orderservice.dto.CreditCardDto;
import com.geekshirt.orderservice.dto.CustomerDto;
import com.geekshirt.orderservice.util.AccountStatus;

@Component
public class CustomerServiceClient {

	@Autowired
	private OrderServiceConfig config;
	private RestTemplate restTemplate;

	public CustomerServiceClient(RestTemplateBuilder builder) {

		this.restTemplate = builder.build();
	}
	
	
	 public Optional<AccountDto> findAccountById(String accountId) {
	        Optional<AccountDto> result = Optional.empty();
	        try {
	            result = Optional.ofNullable(restTemplate.getForObject(config.getCustomerServiceUrl() + "/{id}", AccountDto.class, accountId));
	        }
	        catch (HttpClientErrorException ex)   {
	            if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
	                throw ex;
	            }
	        }
	        return result;
	    }

	
	
	
	
	public AccountDto crateDummyAccount() {
		
		AddressDto addressDto=AddressDto.builder().street("Carreta 7")
				.city("Bogota")
				.state("Bogota")
				.country("Cololmbia")
				.zipCode("12365")
				.build();
		
		CustomerDto customerDto=CustomerDto.builder()
				.lastName("Jose")
				.firstName("Edwin")
				.email("abc@gmail.com")
				.build();
		
		
		CreditCardDto creditCardDto=CreditCardDto.builder().nameOnCard("Edwin Gamboa")
				.number("1233-1555-555")
				.expirationMonth("03")
				.expirationYear("2026")
				.type("Visa")
				.ccv("569")
				.build();
		AccountDto account=AccountDto.builder()
				.address(addressDto)
				.customer(customerDto)
				.creditCard(creditCardDto)
				.status(AccountStatus.ACTIVE)
				.build();
		
		return account;
		
	}
	
	public AccountDto crateAccount(AccountDto accountDto) {
		return restTemplate.postForObject(config.getCustomerServiceUrl(), accountDto, AccountDto.class);
		
	}
}
