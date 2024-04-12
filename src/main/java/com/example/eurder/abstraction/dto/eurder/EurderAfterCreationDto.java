package com.example.eurder.abstraction.dto.eurder;

public class EurderAfterCreationDto {

    private String orderId;
    private float totalPrice;

    public EurderAfterCreationDto() {
    }

    public EurderAfterCreationDto withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public EurderAfterCreationDto withTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}

