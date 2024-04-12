package com.example.eurder.services;

import com.example.eurder.domain.item.Item;
import com.example.eurder.repositories.ItemRepository;
import com.example.eurder.utils.ItemValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    private ItemService itemService;
    private ItemValidator itemValidatorMock;
    private ItemRepository itemRepositoryMock;

    @BeforeEach
    void setUp() {
        itemRepositoryMock = Mockito.mock(ItemRepository.class);
        itemValidatorMock = Mockito.mock(ItemValidator.class);
        itemService = new ItemService(itemRepositoryMock, itemValidatorMock);
    }

    @Test
    void createItem() {
        //GIVEN
//        Item item = anItem().build();
//        Mockito.when(itemValidatorMock.isValidCreation(item)).thenReturn(true);
//        Mockito.when(itemRepositoryMock.save(item)).thenReturn(item);
        //WHEN

        //THEN
    }
}