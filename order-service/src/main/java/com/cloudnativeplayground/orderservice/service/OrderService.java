package com.cloudnativeplayground.orderservice.service;

import com.cloudnativeplayground.orderservice.model.Order;
import com.cloudnativeplayground.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private OrderRepository orderRepository;

    public void placeOrder(Order order) {
        orderRepository.save(order);
        kafkaTemplate.send("orders", "Order placed: " + order.getId());
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found!"));
    }
}
