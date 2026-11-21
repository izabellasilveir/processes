package com.saga.processes.choreography.controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saga.processes.OrderCreateRequest;
import com.saga.processes.choreography.events.OrderCreated;

@RestController 
@RequestMapping("/choreo/orders")
public class ChoreographyController {

    private ApplicationEventPublisher publisher;

    public ChoreographyController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping 
    public ResponseEntity<String> createOrder(@RequestBody OrderCreateRequest request) {
        OrderCreated orderCreated = new OrderCreated();
        orderCreated.setRequest(request);

        publisher.publishEvent(orderCreated);
        return ResponseEntity.ok("Order created initiated");
    }
}
