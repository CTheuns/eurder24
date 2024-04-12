package com.example.eurder.domain.testbuilder.item;

import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.Item.ItemBuilder;
import com.example.eurder.domain.item.Price;
import com.example.eurder.domain.user.userDetails.Builder;

import java.util.UUID;

import static com.example.eurder.domain.item.Item.ItemBuilder.item;
import static java.math.BigDecimal.valueOf;

public class ItemTestBuilder extends Builder<Item> {

    private ItemBuilder itemBuilder;

    private ItemTestBuilder(ItemBuilder itemBuilder) {
        this.itemBuilder = itemBuilder;
    }

    public static ItemTestBuilder anEmptyItem() {
        return new ItemTestBuilder(item());
    }

    public static ItemTestBuilder anItem() {
        return new ItemTestBuilder(item()
                                           .withName("testItem")
                                           .withDescription("Just a simple testItem")
                                           .withAmountInStock(20)
                                           .withPrice(Price.create(valueOf(29.35))));
    }

    @Override
    public Item build() {
        return itemBuilder.build();
    }

    public ItemTestBuilder withId(UUID id) {
        itemBuilder.withId(id);
        return this;
    }

    public ItemTestBuilder withName(String name) {
        itemBuilder.withName(name);
        return this;
    }

    public ItemTestBuilder withDescription(String description) {
        itemBuilder.withDescription(description);
        return this;
    }

    public ItemTestBuilder withPrice(Price price) {
        itemBuilder.withPrice(price);
        return this;
    }

    public ItemTestBuilder withAmountInStock(int amountInStock) {
        itemBuilder.withAmountInStock(amountInStock);
        return this;
    }
}
