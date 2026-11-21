package com.saga.processes;

public class OrderCreateRequest {

    private String orderId;
    private boolean isOrderConfirmed;

    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public boolean isOrderConfirmed() {
        return isOrderConfirmed;
    }
    
    public void setOrderConfirmed(boolean isOrderConfirmed) {
        this.isOrderConfirmed = isOrderConfirmed;
    }


}
