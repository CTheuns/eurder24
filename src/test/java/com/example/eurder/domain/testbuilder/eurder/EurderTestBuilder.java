package com.example.eurder.domain.testbuilder.eurder;

import com.example.eurder.domain.eurder.Eurder;
import com.example.eurder.domain.eurder.Eurder.EurderBuilder;
import com.example.eurder.domain.eurder.EurderItem;
import com.example.eurder.domain.user.userDetails.Builder;

import java.util.Arrays;
import java.util.UUID;

import static com.example.eurder.domain.testbuilder.eurder.EurderItemTestBuilder.anOrderItem;

public class EurderTestBuilder extends Builder<Eurder> {

    private EurderBuilder eurderBuilder;

    private EurderTestBuilder(EurderBuilder eurderBuilder){
        this.eurderBuilder = eurderBuilder;
    }

    public static EurderTestBuilder anEmptyOrder(){
        return new EurderTestBuilder(EurderBuilder.eurderBuilder());
    }

    public static EurderTestBuilder anOrder() {
        return new EurderTestBuilder(EurderBuilder.eurderBuilder()
                                                .withCustomerId(UUID.randomUUID())
                                                .withOrderItems(Arrays.asList(anOrderItem().build(), anOrderItem().build())));
    }

    @Override
    public Eurder build() {
        return new Eurder(eurderBuilder);
    }

    public EurderTestBuilder withId(UUID id) {
        eurderBuilder.withId(id);
        return this;
    }

    public EurderTestBuilder withOrderItems(EurderItem... orderItems) {
        eurderBuilder.withOrderItems(Arrays.asList(orderItems));
        return this;
    }

    public EurderTestBuilder withCustomerId(UUID customerId) {
        eurderBuilder.withCustomerId(customerId);
        return this;
    }
}
