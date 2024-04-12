package com.example.eurder.domain.item;

import com.example.eurder.domain.user.userDetails.Builder;

import java.util.UUID;

public class Item {

    private UUID uuid;
    private final String name;
    private final String description;
    private Price price;
    private int amountInStock;

    public Item(ItemBuilder itemBuilder) {
        this.uuid = itemBuilder.uuid;
        this.name = itemBuilder.name;
        this.description = itemBuilder.description;
        this.price = itemBuilder.price;
        this.amountInStock = itemBuilder.amountInStock;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("uuid=").append(uuid);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price);
        sb.append(", amountInStock=").append(amountInStock);
        return sb.toString();
    }

    public static class ItemBuilder extends Builder<Item>{

        private UUID uuid;
        private String name;
        private String description;
        private Price price;
        private int amountInStock;

        public static ItemBuilder item() {
            return new ItemBuilder();
        }

        @Override
        public Item build() {
            return new Item(this);
        }

        public ItemBuilder withId(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public ItemBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ItemBuilder withPrice(Price price) {
            this.price = price;
            return this;
        }

        public ItemBuilder withAmountInStock(int amountInStock) {
            this.amountInStock = amountInStock;
            return this;
        }
    }
}
