package com.example.order.utils;

import com.example.order.domain.user.Customer;
import com.example.order.domain.user.userDetails.Adress;
import com.example.order.domain.user.userDetails.EmailAdress;
import com.example.order.domain.user.userDetails.PhoneNumber;
import com.example.order.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerValidatorTest {

    @Test
    void testValidationOfCreateCustomerWithAllFields() {
        CustomerValidator validator = new CustomerValidator();
        Customer validCustomer = Customer.CustomerBuilder.customerBuilder()
                                                         .withId(UUID.randomUUID())
                                                         .withFirstName("Test")
                                                         .withLastName("Case")
                                                         .withEmail(EmailAdress.EmailBuilder.email()
                                                                                            .withPersonalPart("email")
                                                                                            .withDomainName("@mail")
                                                                                            .build())
                                                         .withAdress(Adress.AdressBuilder.adress()
                                                                                         .withStreetName("someroad")
                                                                                         .withHouseNumber("8")
                                                                                         .withPostalCode("code")
                                                                                         .withCity("someplace")
                                                                                         .withCountry("somewhere")
                                                                                         .build())
                                                         .withPhoneNumber(PhoneNumber.PhoneNumberBuilder.phoneNumber()
                                                                                                        .withNumber("123456")
                                                                                                        .withCountryCode("++78")
                                                                                                        .build())
                                                         .build();

        assertThat(validator.isValidCreation(validCustomer)).isFalse();
        // Test with empty first name
        validCustomer = Customer.CustomerBuilder.customerBuilder().withFirstName("").build();
        assertThat(validator.isValidCreation(validCustomer)).isTrue();
        // Test with null address
        validCustomer = Customer.CustomerBuilder.customerBuilder().withAdress(null).build();
        assertThat(validator.isValidCreation(validCustomer)).isTrue();
        // Test with empty street name
        validCustomer = Customer.CustomerBuilder.customerBuilder().withAdress(Adress.AdressBuilder.adress().withStreetName("").build()).build();
        assertThat(validator.isValidCreation(validCustomer)).isTrue();
    }
}

