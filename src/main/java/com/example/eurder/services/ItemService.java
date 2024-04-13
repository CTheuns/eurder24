package com.example.eurder.services;

import com.example.eurder.domain.item.Item;
import com.example.eurder.repositories.ItemRepository;
import com.example.eurder.utils.validator.ItemValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public Item getItem(UUID itemId) {
        return itemRepository.get(itemId);
    }

    public Item updateItem(Item item) {
        if (!itemValidator.isUpdateValid(item)){
            itemValidator.throwInvalidStateException(item, "updating");
        }
        return itemRepository.update(item);
    }
}
