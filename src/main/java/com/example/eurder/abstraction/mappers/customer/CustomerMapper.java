package com.example.eurder.abstraction.mappers.customer;

import com.example.eurder.abstraction.dto.customer.CustomerDto;
import com.example.eurder.domain.user.Customer;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerMapper {

    private final AdressMapper adressMapper;
    private final EmailAdressMapper emailAdressMapper;
    private final PhoneNumberMapper phoneNumberMapper;


    public CustomerMapper(AdressMapper adressMapper, EmailAdressMapper emailAdressMapper, PhoneNumberMapper phoneNumberMapper) {
        this.adressMapper = adressMapper;
        this.emailAdressMapper = emailAdressMapper;
        this.phoneNumberMapper = phoneNumberMapper;
    }

    public CustomerDto toDto(Customer customer){
        return new CustomerDto()
                .withId(customer.getUuid())
                .withFirstName(customer.getFirstName())
                .withLastName(customer.getLastName())
                .withRole(customer.getRole())
                .withEmail(emailAdressMapper.toDto(customer.getEmailAdress()))
                .withAddress(adressMapper.toDto(customer.getAdress()))
                .withPhoneNumber(phoneNumberMapper.toDto(customer.getPhoneNumber()));
    }

    public Customer ToDomain (CustomerDto customerDto){
        return Customer.CustomerBuilder.customerBuilder()
                .withId(UUID.fromString(customerDto.getUuid()))
                .withFirstName(customerDto.getFirstName())
                .withLastName(customerDto.getLastName())
                .withRole(customerDto.getRole())
                .withEmail(emailAdressMapper.toDomain(customerDto.getEmailAdress()))
                .withAdress(adressMapper.toDomain(customerDto.getAdress()))
                .withPhoneNumber(phoneNumberMapper.toDomain(customerDto.getPhoneNumber()))
                .build();
    }
}
