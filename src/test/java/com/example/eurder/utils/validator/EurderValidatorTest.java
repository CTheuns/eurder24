package com.example.eurder.utils.validator;

import com.example.eurder.domain.testbuilder.eurder.EurderItemTestBuilder;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.example.eurder.domain.testbuilder.eurder.EurderTestBuilder.anOrder;
import static org.assertj.core.api.Assertions.assertThat;

class EurderValidatorTest {

    @Test
    void isValidForCreation_happyPath() {
        assertThat(new EurderValidator()
                           .isValidCreation(anOrder().build()))
                .isTrue();
    }

    @Test
    void isValidForCreation_givenAnId_thenNotValidForCreation() {
        assertThat(new EurderValidator()
                           .isValidCreation(anOrder()
                                                    .withId(UUID.randomUUID())
                                                    .build()))
                .isFalse();
    }

    @Test
    void isValidForCreation_givenSomeMissingValues_thenNotValidForCreation() {
        assertThat(new EurderValidator()
                           .isValidCreation(anOrder()
                                                    .withCustomerId(null)
                                                    .withOrderItems(EurderItemTestBuilder.anOrderItem()
                                                                                         .withItemPrice(null)
                                                                                         .withOrderedAmount(0)
                                                                                         .build())
                                                    .build()))
                .isFalse();
    }
}