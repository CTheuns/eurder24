package com.example.eurder.abstraction.mappers.eurder;

import com.example.eurder.abstraction.dto.eurder.ItemGroupDto;
import com.example.eurder.domain.eurder.EurderItem;
import com.example.eurder.domain.item.Item;
import com.example.eurder.domain.item.Price;
import com.example.eurder.services.ItemService;
import com.example.eurder.utils.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.example.eurder.domain.eurder.EurderItem.EuderItemBuilder.euderItemBuilder;

@Component
public class EurderItemMapper {

    private ItemService itemService;

    public EurderItemMapper(ItemService itemService) {
        this.itemService = itemService;
    }

    public EurderItem toDomain(ItemGroupDto itemGroupDto) {
        return euderItemBuilder()
                .withItemId(UUID.fromString(itemGroupDto.getItemId()))
                .withOrderedAmount(itemGroupDto.getOrderedAmount())
                .withItemPrice(enrichWithItemPrice(itemGroupDto))
                .withShippingDateBasedOnItemStock(enrichWithItemAmountOfStock(itemGroupDto))
                .build();
    }

    private Price enrichWithItemPrice(ItemGroupDto itemGroupDto) {
        return getItemForId(itemGroupDto.getItemId()).getPrice();
    }

    private int enrichWithItemAmountOfStock(ItemGroupDto itemGroupDto) {
        return getItemForId(itemGroupDto.getItemId()).getAmountInStock();
    }

    public ItemGroupDto toDto(EurderItem eurderItem) {
        return new ItemGroupDto()
                .withItemId(eurderItem.getItemId().toString())
                .withOrderedAmount(eurderItem.getOrderedAmount());
    }


    private Item getItemForId(String itemIdAsString) {
        Item item = itemService.getItem(UUID.fromString(itemIdAsString));
        if (item == null) {
            throw new EntityNotFoundException("mapping to an order of an item group (for creating a new order)",
                                              Item.class, UUID.fromString(itemIdAsString));
        }
        return item;
    }
}
