package com.example.order.abstraction.dto.item;

import java.util.UUID;

public class ItemDto {

    private String uuid;
    private String name;
    private String description;
    private float price;
    private int amountInStock;

    public ItemDto() {
    }

    public ItemDto withId(UUID uuid) {
        this.uuid = uuid.toString();
        return this;
    }

    public ItemDto withoutId() {
        this.uuid = null;
        return this;
    }

    public ItemDto withName(String name) {
        this.name = name;
        return this;
    }

    public ItemDto withDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDto withPrice(float price) {
        this.price = price;
        return this;
    }

    public ItemDto withAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }
}
