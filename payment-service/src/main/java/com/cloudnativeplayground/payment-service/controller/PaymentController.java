package com.cloudnativeplayground.paymentservice.controller;

import com.cloudnativeplayground.paymentservice.model.Payment;
import com.cloudnativeplayground.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public String processPayment(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }
}