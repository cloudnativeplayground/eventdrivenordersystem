package com.cloudnativeplayground.paymentservice.service;

import com.cloudnativeplayground.paymentservice.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String processPayment(Payment payment) {
        // Simulate payment processing
        payment.setStatus("Processed");
        return "Payment processed for order ID: " + payment.getOrderId();
    }
}