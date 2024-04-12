package com.example.eurder.domain.testbuilder.customer;

import com.example.eurder.domain.user.Customer;
import com.example.eurder.domain.user.Customer.CustomerBuilder;
import com.example.eurder.domain.user.userDetails.Adress;
import com.example.eurder.domain.user.userDetails.Builder;
import com.example.eurder.domain.user.userDetails.EmailAdress;
import com.example.eurder.domain.user.userDetails.PhoneNumber;

import java.util.UUID;

import static com.example.eurder.domain.testbuilder.customer.AdressTestBuilder.anAdress;
import static com.example.eurder.domain.testbuilder.customer.EmailTestBuilder.anEmail;
import static com.example.eurder.domain.testbuilder.customer.PhoneNumberTestBuilder.aPhoneNumber;

public class CustomerTestBuilder extends Builder<Customer> {

    private CustomerBuilder customerBuilder;

    private CustomerTestBuilder(CustomerBuilder customerBuilder){
    this.customerBuilder = customerBuilder;
    }

    public static CustomerTestBuilder anEmptyCustomer(){
        return new CustomerTestBuilder(CustomerBuilder.customerBuilder());
    }

    public static CustomerTestBuilder aCustomer(){
        return new CustomerTestBuilder(CustomerBuilder.customerBuilder()
                                                      .withFirstName("test")
                                                      .withLastName("dummy")
                                                      .withEmail(anEmail().build())
                                                      .withAdress(anAdress().build())
                                               .withPhoneNumber(aPhoneNumber().build())
        );
    }

    @Override
    public Customer build() {
        return customerBuilder.build();
    }

    public CustomerTestBuilder withId(UUID id) {
        customerBuilder.withId(id);
        return this;
    }

    public CustomerTestBuilder withFirstName(String firstname) {
        customerBuilder.withFirstName(firstname);
        return this;
    }

    public CustomerTestBuilder withLastName(String lastname) {
        customerBuilder.withLastName(lastname);
        return this;
    }

    public CustomerTestBuilder withEmail(EmailAdress email) {
        customerBuilder.withEmail(email);
        return this;
    }

    public CustomerTestBuilder withAdress(Adress adress) {
        customerBuilder.withAdress(adress);
        return this;
    }

    public CustomerTestBuilder withPhoneNumber(PhoneNumber phoneNumber) {
        customerBuilder.withPhoneNumber(phoneNumber);
        return this;
    }
}
