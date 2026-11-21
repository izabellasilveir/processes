package com.saga.processes.choreography.llisteners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.saga.processes.choreography.events.OrderFailed;

@Component 
public class CompensationListener {

    @EventListener 
    public void handle(OrderFailed orderFailed) {
        System.out.println("Refunding payment for: " + orderFailed.getRequest().getOrderId());
    }
}
