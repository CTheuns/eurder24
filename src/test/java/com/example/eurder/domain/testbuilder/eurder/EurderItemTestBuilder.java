package com.example.eurder.domain.testbuilder.eurder;

import com.example.eurder.domain.eurder.EurderItem;
import com.example.eurder.domain.eurder.EurderItem.EuderItemBuilder;
import com.example.eurder.domain.item.Price;
import com.example.eurder.domain.user.userDetails.Builder;

import java.math.BigDecimal;
import java.util.UUID;

public class EurderItemTestBuilder extends Builder<EurderItem> {

    private EuderItemBuilder orderItemBuilder;

    private EurderItemTestBuilder(EuderItemBuilder orderItemBuilder) {
        this.orderItemBuilder = orderItemBuilder;
    }

    public static EurderItemTestBuilder anEmptyOrderItem() {
        return new EurderItemTestBuilder(EurderItem.EuderItemBuilder.euderItemBuilder());
    }

    public static EurderItemTestBuilder anOrderItem() {
        return new EurderItemTestBuilder(EurderItem.EuderItemBuilder.euderItemBuilder()
                                                                  .withItemId(UUID.randomUUID())
                                                                  .withItemPrice(Price.create(BigDecimal.valueOf(49.95)))
                                                                  .withOrderedAmount(10)
                                                                  .withShippingDateBasedOnItemStock(15)
        );
    }

    @Override
    public EurderItem build() {
        return orderItemBuilder.build();
    }

    public EurderItemTestBuilder withItemId(UUID itemId) {
        orderItemBuilder.withItemId(itemId);
        return this;
    }

    public EurderItemTestBuilder withItemPrice(Price itemPrice) {
        orderItemBuilder.withItemPrice(itemPrice);
        return this;
    }

    public EurderItemTestBuilder withOrderedAmount(int orderedAmount) {
        orderItemBuilder.withOrderedAmount(orderedAmount);
        return this;
    }

    public EurderItemTestBuilder withShippingDateBasedOnAvailableItemStock(int availableItemStock) {
        orderItemBuilder.withShippingDateBasedOnItemStock(availableItemStock);
        return this;
    }
}
