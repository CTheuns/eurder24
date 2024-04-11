package com.example.order.utils;

import com.example.order.domain.user.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

private final Logger customerValidationLogger = LoggerFactory.getLogger(CustomerValidator.class);

    public boolean isValidCreation(Customer customer) {
        return isNull(customer)
               || isEmptyOrNull(customer.getFirstName())
               || isEmptyOrNull(customer.getLastName())
               || isNull(customer.getAdress())
               || isEmptyOrNull(customer.getAdress().getStreetName())
               || isEmptyOrNull(customer.getAdress().getHouseNumber())
               || isEmptyOrNull(customer.getAdress().getPostalCode())
               || isEmptyOrNull(customer.getAdress().getCountry())
               || isNull(customer.getEmailAdress())
               || isEmptyOrNull(customer.getEmailAdress().getDomainName())
               || isEmptyOrNull(customer.getEmailAdress().getPersonalPart())
               || isNull(customer.getPhoneNumber())
               || isEmptyOrNull(customer.getPhoneNumber().getCountryCode())
               || isEmptyOrNull(customer.getPhoneNumber().getPhoneNumber());
    }

    protected boolean isEmptyOrNull(String field) {
        return field == null || field.isEmpty();
    }

    protected boolean isNull(Object object) {
        return object == null;
    }

    public void throwInvalidStateException(Customer customer, String type) {
        customerValidationLogger.error("Invalid input while creating new customer.");
        throw new IllegalStateException("Invalid " + (customer == null ? "NULL_ENTITY" : customer.getClass().getSimpleName())
                                        + " provided for " + type + ". Provided object: " + (customer == null ? null : customer.toString()));
    }
}
