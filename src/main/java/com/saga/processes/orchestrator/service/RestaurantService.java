package com.saga.processes.orchestrator.service;

import org.springframework.stereotype.Service;

import com.saga.processes.OrderCreateRequest;

@Service 
public class RestaurantService {

    public void confirmOrder(OrderCreateRequest request) {
        if (request.isOrderConfirmed()) {
            System.out.println("Order confirmed for: " + request.getOrderId());
        } else {
            throw new RuntimeException("Restaurant not available");
        }
    }
}
