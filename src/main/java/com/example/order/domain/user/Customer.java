package com.example.order.domain.user;

import com.example.order.domain.user.userDetails.Adress;
import com.example.order.domain.user.userDetails.Builder;
import com.example.order.domain.user.userDetails.EmailAdress;
import com.example.order.domain.user.userDetails.PhoneNumber;
import com.example.order.domain.user.userDetails.Role;

import java.util.UUID;

public class Customer {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private Role role;
    private EmailAdress emailAdress;
    private Adress adress;
    private PhoneNumber phoneNumber;

    private Customer(CustomerBuilder customerBuilder) {
        this.uuid = customerBuilder.id;
        this.firstName = customerBuilder.firstName;
        this.lastName = customerBuilder.lastName;
        this.role = customerBuilder.role;
        this.emailAdress = customerBuilder.emailAdress;
        this.adress = customerBuilder.adress;
        this.phoneNumber = customerBuilder.phoneNumber;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }

    public EmailAdress getEmailAdress() {
        return emailAdress;
    }

    public Adress getAdress() {
        return adress;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void generateId() {
        if (uuid != null){
            throw new IllegalStateException("Generating an ID when customer already has " +
                                            "one (" + uuid + ") is not allowed.");
        }
        uuid = UUID.randomUUID();
        }


    public static class CustomerBuilder extends Builder<Customer>{

        private UUID id;
        private String firstName;
        private String lastName;
        private Role role;
        private EmailAdress emailAdress;
        private Adress adress;
        private PhoneNumber phoneNumber;

        private CustomerBuilder(){}

        public static CustomerBuilder customerBuilder() {
            return new CustomerBuilder();
        }

        @Override
        public Customer build() {
            return new Customer(this);
        }

        public CustomerBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerBuilder withRole(Role role){
            this.role = role;
            return this;
        }

        public CustomerBuilder withEmail(EmailAdress emailAdress) {
            this.emailAdress = emailAdress;
            return this;
        }

        public CustomerBuilder withAdress(Adress adress) {
            this.adress = adress;
            return this;
        }

        public CustomerBuilder withPhoneNumber(PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
    }
}
