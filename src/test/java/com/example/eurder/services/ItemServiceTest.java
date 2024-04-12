package com.example.eurder.services;

import com.example.eurder.domain.item.Item;
import com.example.eurder.repositories.ItemRepository;
import com.example.eurder.utils.validator.ItemValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.example.eurder.domain.testbuilder.item.ItemTestBuilder.anItem;

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
        Item item = anItem().build();
        Mockito.when(itemValidatorMock.isValidCreation(item)).thenReturn(true);
        Mockito.when(itemRepositoryMock.save(item)).thenReturn(item);
        //WHEN
        Item createdItem = itemService.createItem(item);
        //THEN
        Assertions.assertThat(createdItem).isNotNull();
    }

    @Test
    void createItem_givenItemThatIsNotValidForCreation_thenThrowException() {
        Item item = anItem().build();
        Mockito.when(itemValidatorMock.isValidCreation(item)).thenReturn(false);
        Mockito.doThrow(IllegalStateException.class).when(itemValidatorMock)
               .throwInvalidStateException(item, "creation");

        Assertions.assertThatExceptionOfType(IllegalStateException.class)
                  .isThrownBy(() -> itemService.createItem(item));
    }
}