package com.saga.processes.orchestrator.service;

import org.springframework.stereotype.Service;

import com.saga.processes.OrderCreateRequest;

@Service 
public class PaymentService {

    public void processPayment(OrderCreateRequest request) {
        System.out.println("Payment processed for request: " + request.getOrderId());
    }

    public void refundPayment(OrderCreateRequest request) {
        System.out.println("Payment refunded for request: " + request.getOrderId());
    }
}
