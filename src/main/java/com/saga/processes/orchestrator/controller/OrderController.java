package com.saga.processes.orchestrator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saga.processes.OrderCreateRequest;
import com.saga.processes.orchestrator.service.SagaOrchestrator;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final SagaOrchestrator orchestrator;

    public OrderController(SagaOrchestrator orchestrator) {
        this.orchestrator = orchestrator;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderCreateRequest request) {
        return ResponseEntity.ok(orchestrator.startSaga(request));
    }

}
