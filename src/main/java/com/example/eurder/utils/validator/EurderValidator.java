package com.example.eurder.utils.validator;

import com.example.eurder.domain.eurder.Eurder;
import com.example.eurder.domain.eurder.EurderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EurderValidator extends ValidatorModel<Eurder> {

    @Override
    protected boolean isFieldEmptyOrNull(Eurder eurder) {
        return isNull(eurder)
               || isNull(eurder.getCustomerId())
               || eurder.getOrderItems().isEmpty()
               || isOrderItemInvalid(eurder.getOrderItems());
    }

    private boolean isOrderItemInvalid(List<EurderItem> orderItems) {
        return orderItems.stream()
                         .map(orderItem -> isNull(orderItem.getItemId())
                                           || isNull(orderItem.getItemPrice())
                                           || orderItem.getItemPrice().getAmountAsFloat() <= 0
                                           || orderItem.getOrderedAmount() <= 0
                                           || isNull(orderItem.getShippingDate()))
                         .filter(isInvalidOrderItem -> isInvalidOrderItem)
                         .findFirst()
                         .orElse(false);
    }
}
