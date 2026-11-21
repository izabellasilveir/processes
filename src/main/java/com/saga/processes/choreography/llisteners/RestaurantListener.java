package com.saga.processes.choreography.llisteners;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.saga.processes.choreography.events.OrderFailed;
import com.saga.processes.choreography.events.PaymentSuccess;

@Component 
public class RestaurantListener {

    private ApplicationEventPublisher publisher;

    public RestaurantListener(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @EventListener 
    public void handle(PaymentSuccess paymentSuccessEvent) {
        if (paymentSuccessEvent.getRequest().isOrderConfirmed()) {
            System.out.println("Order accepted for request: " + paymentSuccessEvent.getRequest().getOrderId());
        } else {
            OrderFailed orderFailedEvent = new OrderFailed();
            orderFailedEvent.setRequest(paymentSuccessEvent.getRequest());
            publisher.publishEvent(orderFailedEvent);
        }
    }
}
