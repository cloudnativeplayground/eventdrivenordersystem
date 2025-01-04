package com.cloudnativeplayground.paymentservice.controller;

import com.cloudnativeplayground.paymentservice.model.Payment;
import com.cloudnativeplayground.paymentservice.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PaymentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    @Test
    void processPayment_shouldReturnOk() throws Exception {
        Payment payment = new Payment();
        payment.setOrderId("123");
        payment.setAmount(new java.math.BigDecimal("100.00"));

        when(paymentService.processPayment(any(Payment.class))).thenReturn("Payment processed for order ID: 123");

        mockMvc.perform(post("/payments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{"orderId":"123","amount":100.00}"))
                .andExpect(status().isOk());

        verify(paymentService, times(1)).processPayment(any(Payment.class));
    }
}