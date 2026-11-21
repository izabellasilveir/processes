package com.saga.processes.orchestrator.service;

import org.springframework.stereotype.Service;

import com.saga.processes.OrderCreateRequest;

@Service 
public class SagaOrchestrator {

    private final PaymentService paymentService;
    private final RestaurantService restaurantService;
    
    public SagaOrchestrator(PaymentService paymentService, RestaurantService restaurantService) {
        this.paymentService = paymentService;
        this.restaurantService = restaurantService;
    }

    public String startSaga(OrderCreateRequest request) {
        paymentService.processPayment(request);
        try {
            restaurantService.confirmOrder(request);
            return "Order successfull";
        } catch (Exception e) {
            paymentService.refundPayment(request);
            return "Order failed";
        }
    }
}
