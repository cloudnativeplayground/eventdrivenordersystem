package com.cloudnativeplayground.orderservice.service;

import com.cloudnativeplayground.orderservice.model.Order;
import com.cloudnativeplayground.orderservice.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlaceOrder() {
        Order order = new Order();
        order.setId(1L);
        order.setProductName("Laptop");
        order.setQuantity(2);
        order.setPrice(1200.0);

        when(orderRepository.save(order)).thenReturn(order);

        orderService.placeOrder(order);

        verify(orderRepository, times(1)).save(order);
        verify(kafkaTemplate, times(1)).send("orders", "Order placed: " + order.getId());
    }

    @Test
    public void testGetOrderById() {
        Order order = new Order();
        order.setId(1L);
        order.setProductName("Laptop");
        order.setQuantity(2);
        order.setPrice(1200.0);

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order result = orderService.getOrderById(1L);

        assertNotNull(result);
        assertEquals("Laptop", result.getProductName());
        assertEquals(2, result.getQuantity());
        assertEquals(1200.0, result.getPrice());
    }
}
