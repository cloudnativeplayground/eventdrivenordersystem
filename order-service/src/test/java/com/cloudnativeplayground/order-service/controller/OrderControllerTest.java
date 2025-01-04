package com.cloudnativeplayground.orderservice.controller;

import com.cloudnativeplayground.orderservice.model.Order;
import com.cloudnativeplayground.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void testPlaceOrder() throws Exception {
        Order order = new Order();
        order.setId(1L);
        order.setProductName("Laptop");
        order.setQuantity(2);
        order.setPrice(1200.0);

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"productName\":\"Laptop\",\"quantity\":2,\"price\":1200.0}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Order placed successfully!"));
    }

    @Test
    public void testGetOrder() throws Exception {
        Order order = new Order();
        order.setId(1L);
        order.setProductName("Laptop");
        order.setQuantity(2);
        order.setPrice(1200.0);

        when(orderService.getOrderById(1L)).thenReturn(order);

        mockMvc.perform(get("/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productName").value("Laptop"))
                .andExpect(jsonPath("$.quantity").value(2))
                .andExpect(jsonPath("$.price").value(1200.0));
    }
}
