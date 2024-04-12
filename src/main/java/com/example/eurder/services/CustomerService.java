package com.example.eurder.services;

import com.example.eurder.abstraction.mappers.customer.CustomerMapper;
import com.example.eurder.domain.user.Customer;
import com.example.eurder.repositories.CustomerRepository;
import com.example.eurder.utils.validator.CustomerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    private CustomerValidator validator;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper, CustomerValidator validator) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.validator = validator;
    }

    private final Logger myLogger = LoggerFactory.getLogger(CustomerService.class);

    public Customer createNewCustomer(Customer customer) {
        if (!validator.isValidCreation(customer)){
            validator.throwInvalidStateException(customer, "creation");
            myLogger.error(String.format( "Invalid input while creating new customer %s ", customer));
        }
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerRepository.getAll().values());
    }

    public Customer getCustomer(UUID id) {
        return customerRepository.get(id);
    }
}
