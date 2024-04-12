package com.example.eurder.services;

import com.example.eurder.domain.eurder.Eurder;
import com.example.eurder.domain.eurder.EurderItem;
import com.example.eurder.domain.user.Customer;
import com.example.eurder.repositories.CustomerRepository;
import com.example.eurder.repositories.EurderRepository;
import com.example.eurder.repositories.ItemRepository;
import com.example.eurder.utils.exception.EntityNotFoundException;
import com.example.eurder.utils.exception.EntityNotValidException;
import com.example.eurder.utils.validator.EurderValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EurderService {

    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final EurderRepository eurderRepository;
    private final EurderValidator eurderValidator;

    public EurderService(CustomerRepository customerRepository, ItemRepository itemRepository, EurderRepository eurderRepository, EurderValidator eurderValidator) {
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.eurderRepository = eurderRepository;
        this.eurderValidator = eurderValidator;
    }

    public Eurder createOrder(Eurder order) {
        assertOrderIsValidForCreation(order);
        assertOrderingCustomerExists(order);
        assertAllOrderedItemsExist(order);
        return eurderRepository.save(order);
    }

    private void assertAllOrderedItemsExist(Eurder order) {
        if (!doAllOrderItemsReferenceAnExistingItem(order.getOrderItems())) {
            throw new EntityNotValidException("creation of a new order when checking if all the ordered items exist",
                                              order);
        }
    }

    private boolean doAllOrderItemsReferenceAnExistingItem(List<EurderItem> orderItems) {
        return orderItems.stream()
                         .filter(orderItem -> itemRepository.get(orderItem.getItemId()) == null)
                         .map(nonExistingItem -> false)
                         .findFirst()
                         .orElse(true);
    }

    private void assertOrderingCustomerExists(Eurder order) {
        if (!doesCustomerExist(order)) {
            throw new EntityNotFoundException("creation of a new order when checking if the referenced customer exists",
                                              Customer.class, order.getCustomerId());
        }
    }

    private boolean doesCustomerExist(Eurder order) {
        return customerRepository.get(order.getCustomerId()) != null;
    }

    private void assertOrderIsValidForCreation(Eurder order) {
        if (!eurderValidator.isValidCreation(order)) {
            eurderValidator.throwInvalidStateException(order, "creation");
        }
    }


}
