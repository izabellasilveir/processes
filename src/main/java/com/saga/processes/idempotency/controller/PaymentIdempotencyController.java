package com.saga.processes.idempotency.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saga.processes.idempotency.dto.PaymentRequest;
import com.saga.processes.idempotency.service.PaymentIdempotencyService;

@RestController 
@RequestMapping("/payments")
public class PaymentIdempotencyController {

    private final PaymentIdempotencyService paymentService;

    public PaymentIdempotencyController(PaymentIdempotencyService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping 
    public ResponseEntity<String> createPayment(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(paymentService.processPayment(request));
    }
}
