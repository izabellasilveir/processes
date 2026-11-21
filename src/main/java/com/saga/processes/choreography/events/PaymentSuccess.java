package com.saga.processes.choreography.events;

import com.saga.processes.OrderCreateRequest;

public class PaymentSuccess {

    private OrderCreateRequest request;

    public OrderCreateRequest getRequest() {
        return request;
    }

    public void setRequest(OrderCreateRequest request) {
        this.request = request;
    }

}
