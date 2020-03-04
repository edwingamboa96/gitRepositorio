package com.geekshirt.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekshirt.orderservice.client.PaymentServiceClient;
import com.geekshirt.orderservice.dto.AccountDto;
import com.geekshirt.orderservice.dto.Confirmation;
import com.geekshirt.orderservice.dto.CreditCardDto;
import com.geekshirt.orderservice.dto.PaymentDetailsDto;
import com.geekshirt.orderservice.dto.PaymentRequest;
import com.geekshirt.orderservice.entities.Order;
import com.geekshirt.orderservice.util.CurrencyType;

@Service
public class PaymentProcessorService {

	@Autowired
    private PaymentServiceClient paymentClient;

    public Confirmation processPayment(Order order, AccountDto account) {
        PaymentDetailsDto paymentDetailsDto = createPaymentDetails(account);
        PaymentRequest paymentRequest = createPaymentRequest(paymentDetailsDto, order);
        return paymentClient.authorize(paymentRequest);
    }

    private PaymentRequest createPaymentRequest(PaymentDetailsDto paymentDetailsDto, Order order) {
        return PaymentRequest.builder()
                .payment(paymentDetailsDto)
                .accountId(order.getAccountId())
                .amount(order.getTotalAmount())
                .orderId(order.getOrderId())
                .currency(CurrencyType.USD.name())
                .build();
    }

    private PaymentDetailsDto createPaymentDetails(AccountDto account) {
        CreditCardDto cardDetails = account.getCreditCard();
        return PaymentDetailsDto.builder().cardNumber(cardDetails.getNumber())
                .cardCode(cardDetails.getCcv())
                .expirationMonth(cardDetails.getExpirationMonth())
                .expirationYear(cardDetails.getExpirationYear())
                .nameOnCard(cardDetails.getNameOnCard())
                .method(cardDetails.getType())
                .build();
    }
}
