package com.saga.processes.choreography.llisteners;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.saga.processes.choreography.events.OrderCreated;
import com.saga.processes.choreography.events.PaymentSuccess;

@Component 
public class PaymentListener {

    private ApplicationEventPublisher publisher;

    public PaymentListener(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @EventListener 
    public void handle(OrderCreated orderCreatedEvent) {

        System.out.println("Payment processed for order: " + orderCreatedEvent.getRequest().getOrderId());
        PaymentSuccess paymentSuccess = new PaymentSuccess();

        paymentSuccess.setRequest(orderCreatedEvent.getRequest());
        publisher.publishEvent(paymentSuccess);
    }
}

