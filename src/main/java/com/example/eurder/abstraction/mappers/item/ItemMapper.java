package com.example.eurder.abstraction.mappers.item;

import com.example.eurder.abstraction.dto.item.ItemDto;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.Price;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

import static com.example.eurder.domain.item.Item.ItemBuilder.item;

@Component
public class ItemMapper {

    public Item toDomain(UUID itemId, ItemDto itemDto) {
        if (itemDto.getUuid() == null) {
            return toDomain(itemDto.withId(itemId));
        }
        if (!itemId.toString().equals(itemDto.getUuid())) {
            throw new IllegalArgumentException("When updating an item, the id should match the id in the body: " +
                                               "ID in path = " + itemId.toString() + ", ID in body = " + itemDto.getUuid());
        }
        return toDomain(itemDto);
    }

    public Item toDomain(ItemDto itemDto) {
        return item()
                .withId(itemDto.getUuid() == null ? null : UUID.fromString(itemDto.getUuid()))
                .withName(itemDto.getName())
                .withDescription(itemDto.getDescription())
                .withAmountInStock(itemDto.getAmountInStock())
                .withPrice(Price.create(BigDecimal.valueOf(itemDto.getPrice())))
                .build();
    }

    public ItemDto toDto(Item item) {
        return new ItemDto()
                .withId(item.getUuid())
                .withName(item.getName())
                .withDescription(item.getDescription())
                .withAmountInStock(item.getAmountInStock())
                .withPrice(item.getPrice().getAmountAsFloat());
    }
}
