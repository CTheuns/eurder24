package com.example.eurder.services;

import com.example.eurder.domain.eurder.Eurder;
import com.example.eurder.repositories.CustomerRepository;
import com.example.eurder.repositories.EurderRepository;
import com.example.eurder.repositories.ItemRepository;
import com.example.eurder.utils.exception.EntityNotFoundException;
import com.example.eurder.utils.exception.EntityNotValidException;
import com.example.eurder.utils.validator.EurderValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static com.example.eurder.domain.testbuilder.customer.CustomerTestBuilder.aCustomer;
import static com.example.eurder.domain.testbuilder.eurder.EurderItemTestBuilder.anOrderItem;
import static com.example.eurder.domain.testbuilder.eurder.EurderTestBuilder.anOrder;
import static com.example.eurder.domain.testbuilder.item.ItemTestBuilder.anItem;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

public class EurderServiceTes {

    private EurderService eurderService;
    private EurderValidator eurderValidatorMock;
    private EurderRepository eurderRepositoryMock;
    private CustomerRepository customerRepositoryMock;
    private ItemRepository itemRepositoryMock;

    @BeforeEach
    void setupService() {
        eurderRepositoryMock = Mockito.mock(EurderRepository.class);
        eurderValidatorMock = Mockito.mock(EurderValidator.class);
        customerRepositoryMock = Mockito.mock(CustomerRepository.class);
        itemRepositoryMock = Mockito.mock(ItemRepository.class);
        eurderService = new EurderService(customerRepositoryMock, itemRepositoryMock, eurderRepositoryMock, eurderValidatorMock);
    }

    @Test
    void createOrder_happyPath() {
        Eurder order = anOrder().build();
        Mockito.when(eurderValidatorMock.isValidCreation(order)).thenReturn(true);
        Mockito.when(eurderRepositoryMock.save(order)).thenReturn(order);
        Mockito.when(customerRepositoryMock.get(any(UUID.class))).thenReturn(aCustomer().build());
        Mockito.when(itemRepositoryMock.get(any(UUID.class))).thenReturn(anItem().build());

        Eurder createdOrder = eurderService.createOrder(order);

        assertThat(createdOrder).isNotNull();
    }

    @Test
    void createOrder_givenOrderThatIsNotValidForCreation_thenThrowException() {
        Eurder order = anOrder().build();
        Mockito.when(eurderValidatorMock.isValidCreation(order)).thenReturn(false);
        Mockito.doThrow(IllegalStateException.class).when(eurderValidatorMock)
               .throwInvalidStateException(order, "creation");

        Assertions.assertThatExceptionOfType(IllegalStateException.class)
                  .isThrownBy(() -> eurderService.createOrder(order));
    }

    @Test
    void createOrder_customerDoesNotExist() {
        UUID customerId = UUID.randomUUID();
        Eurder order = anOrder().withCustomerId(customerId).build();
        Mockito.when(eurderValidatorMock.isValidCreation(order)).thenReturn(true);
        Mockito.when(eurderRepositoryMock.save(order)).thenReturn(order);
        Mockito.when(customerRepositoryMock.get(customerId)).thenReturn(null);

        Assertions.assertThatExceptionOfType(EntityNotFoundException.class)
                  .isThrownBy(() -> eurderService.createOrder(order))
                  .withMessage("During creation of a new order when checking if the referenced " +
                               "customer exists, the following entity was not found: Customer with id = " + customerId.toString());
    }

    @Test
    void createOrder_orderItemReferencingNonExistingItem() {
        Eurder order = anOrder().withOrderItems(anOrderItem().withItemId(UUID.randomUUID()).build()).build();
        Mockito.when(eurderValidatorMock.isValidCreation(order)).thenReturn(true);
        Mockito.when(eurderRepositoryMock.save(order)).thenReturn(order);
        Mockito.when(customerRepositoryMock.get(any(UUID.class))).thenReturn(aCustomer().build());
        Mockito.when(itemRepositoryMock.get(any(UUID.class))).thenReturn(null);

        Assertions.assertThatExceptionOfType(EntityNotValidException.class)
                  .isThrownBy(() -> eurderService.createOrder(order))
                  .withMessage("During creation of a new order when checking if all the ordered " +
                               "items exist, the following entity was found to be invalid: " + order.toString());
    }

}
