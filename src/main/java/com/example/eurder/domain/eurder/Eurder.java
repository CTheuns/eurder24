package com.example.eurder.domain.eurder;

import com.example.eurder.domain.EntityModel;
import com.example.eurder.domain.item.Price;
import com.example.eurder.domain.user.userDetails.Builder;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Eurder extends EntityModel {

    private final List<EurderItem> eurderItems;
    private final UUID customerId;

    public Eurder(EurderBuilder eurderBuilder) {
        super(eurderBuilder.eurderId);
        this.eurderItems = eurderBuilder.eurderItems;
        this.customerId = eurderBuilder.customerId;
    }

    public List<EurderItem> getOrderItems() {
        return Collections.unmodifiableList(eurderItems);
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public Price getTotalPrice() {
        return eurderItems.stream()
                         .map(EurderItem::getTotalPrice)
                         .reduce(Price.create(BigDecimal.ZERO),
                                 (price1, price2) -> Price.create(price1.getAmount().add(price2.getAmount())));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Örder");
        sb.append("örderItems=").append(eurderItems);
        sb.append(", customerId=").append(customerId);
        return sb.toString();
    }

    public static class EurderBuilder extends Builder<Eurder> {

        private UUID eurderId;
        private List<EurderItem> eurderItems;
        private UUID customerId;

        private EurderBuilder() {
        }

        public static EurderBuilder eurderBuilder() {
            return new EurderBuilder();
        }


        public EurderBuilder withId(UUID id) {
            this.eurderId = id;
            return this;
        }

        public EurderBuilder withOrderItems(List<EurderItem> eurderItems) {
            this.eurderItems = eurderItems;
            return this;
        }

        public EurderBuilder withCustomerId(UUID customerId) {
            this.customerId = customerId;
            return this;
        }

        @Override
        public Eurder build() {
            return new Eurder(this);
        }
    }
}
