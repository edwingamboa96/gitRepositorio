package com.geekshirt.orderservice.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.geekshirt.orderservice.config.OrderServiceConfig;
import com.geekshirt.orderservice.dto.AccountDto;
import com.geekshirt.orderservice.dto.AddressDto;
import com.geekshirt.orderservice.dto.CreditCardDto;
import com.geekshirt.orderservice.dto.CustomerDto;
import com.geekshirt.orderservice.util.AccountStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomerServiceClient {
	private RestTemplate restTemplate;


	@Autowired
	private OrderServiceConfig config;
	
	public CustomerServiceClient(RestTemplateBuilder builder) {

		restTemplate = builder.build();
	}
	
	
	 public Optional<AccountDto> findAccount(String accountId) {
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
				.country("Colombia")
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
	/////////////
	
	 public AccountDto createAccountBody(AccountDto account) {
	        ResponseEntity<AccountDto> responseAccount = restTemplate.postForEntity(config.getCustomerServiceUrl(),
	                                                                                account, AccountDto.class);
	        log.info("Response: " +  responseAccount.getHeaders());
	        return responseAccount.getBody();
	    }

	    public void updateAccount(AccountDto account) {
	        restTemplate.put(config.getCustomerServiceUrl() + "/{id}", account, account.getId());
	    }

	    public void deleteAccount(AccountDto account) {
	        restTemplate.delete(config.getCustomerServiceUrl() + "/{id}", account.getId());
	    }
	
	
	
	
	
	
}
