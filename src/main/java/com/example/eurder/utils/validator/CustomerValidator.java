package com.example.eurder.utils.validator;

import com.example.eurder.domain.user.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator extends ValidatorModel<Customer> {

    @Override
    protected boolean isFieldEmptyOrNull(Customer customer) {
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
}
