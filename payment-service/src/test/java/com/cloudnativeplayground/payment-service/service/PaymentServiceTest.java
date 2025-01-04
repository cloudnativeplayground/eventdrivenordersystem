package com.cloudnativeplayground.paymentservice.service;

import com.cloudnativeplayground.paymentservice.model.Payment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private final PaymentService paymentService = new PaymentService();

    @Test
    void processPayment_shouldReturnProcessedStatus() {
        Payment payment = new Payment();
        payment.setOrderId("123");
        payment.setAmount(new java.math.BigDecimal("100.00"));

        String result = paymentService.processPayment(payment);

        assertEquals("Processed", payment.getStatus());
        assertEquals("Payment processed for order ID: 123", result);
    }
}
