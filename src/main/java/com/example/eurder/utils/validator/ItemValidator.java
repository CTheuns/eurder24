package com.example.eurder.utils.validator;

import com.example.eurder.domain.item.Item;
import org.springframework.stereotype.Component;

@Component
public abstract class ItemValidator extends ValidatorModel<Item> {

    @Override
    protected boolean isFieldEmptyOrNull(Item item) {
        return isNull(item)
               || isEmptyOrNull(item.getName())
               || isEmptyOrNull(item.getDescription())
               || item.getAmountInStock() < 0
               || isNull(item.getPrice())
               || item.getPrice().getAmountAsFloat() <= 0;
    }


}
