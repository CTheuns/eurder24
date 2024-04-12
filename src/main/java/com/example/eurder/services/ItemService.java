package com.example.eurder.services;

import com.example.eurder.domain.item.Item;
import com.example.eurder.repositories.ItemRepository;
import com.example.eurder.utils.ItemValidator;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemValidator itemValidator;

    public ItemService(ItemRepository itemRepository, ItemValidator itemValidator) {
        this.itemRepository = itemRepository;
        this.itemValidator = itemValidator;
    }

    public Item createItem(Item item) {
        if (!itemValidator.isValidCreation(item)){
            itemValidator.throwInvalidStateException(item, "creation");
        }
        return itemRepository.save(item);
    }
}
