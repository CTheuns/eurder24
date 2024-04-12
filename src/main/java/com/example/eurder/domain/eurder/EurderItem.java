package com.example.eurder.domain.eurder;

import com.example.eurder.domain.item.Price;
import com.example.eurder.domain.user.userDetails.Builder;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

public class EurderItem {

    private final UUID itemId;
    private final Price itemPrice;
    private final int orderedAmount;
    private final LocalDate shippingDate;

    public EurderItem(EuderItemBuilder euderItemBuilder, Clock clock) {
        itemId = euderItemBuilder.itemId;
        itemPrice = euderItemBuilder.itemPrice;
        orderedAmount = euderItemBuilder.orderedAmount;
        shippingDate = calculateShippingDate(euderItemBuilder.availableItemStock, clock);
    }

    private LocalDate calculateShippingDate(int availableItemStock, Clock clock) {
        if(availableItemStock - orderedAmount >= 0) {
            return LocalDate.now(clock).plusDays(1);
        } return LocalDate.now(clock).plusDays(7);
    }

    public UUID getItemId() {
        return itemId;
    }

    public Price getItemPrice() {
        return itemPrice;
    }

    public int getOrderedAmount() {
        return orderedAmount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public Price getTotalPrice() {
        return Price.create(itemPrice.getAmount()
                                     .multiply(BigDecimal.valueOf(orderedAmount)));
    }

    @Override
    public String toString() {
        return "OrderItem{" + "itemId=" + itemId +
               ", itemPrice=" + itemPrice +
               ", orderedAmount=" + orderedAmount +
               ", shippingDate=" + shippingDate +
               '}';
    }

    public static class EuderItemBuilder extends Builder<EurderItem> {

        private UUID itemId;
        private Price itemPrice;
        private int orderedAmount;
        private int availableItemStock;

        private EuderItemBuilder() {
        }

        public static EuderItemBuilder euderItemBuilder() {
            return new EuderItemBuilder();
        }

        @Override
        public EurderItem build() {
            return new EurderItem(this, Clock.system(ZoneId.systemDefault()));
        }

        public EuderItemBuilder withItemId(UUID itemId) {
            this.itemId = itemId;
            return this;
        }

        public EuderItemBuilder withItemPrice(Price itemPrice) {
            this.itemPrice = itemPrice;
            return this;
        }

        public EuderItemBuilder withOrderedAmount(int orderedAmount) {
            this.orderedAmount = orderedAmount;
            return this;
        }

        public EuderItemBuilder withShippingDateBasedOnItemStock(int availableItemStock) {
            this.availableItemStock = availableItemStock;
            return this;
        }
    }

}
