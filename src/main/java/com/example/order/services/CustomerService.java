package com.example.order.services;

import com.example.order.abstraction.mappers.customer.CustomerMapper;
import com.example.order.domain.user.Customer;
import com.example.order.repositories.CustomerRepository;
import com.example.order.utils.CustomerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

    private final Logger customerServiceLogger = LoggerFactory.getLogger(CustomerService.class);

    public Customer createNewCustomer(Customer customer) {
        if (!validator.isValidCreation(customer)){
            validator.throwInvalidStateException(customer, "creation");
            customerServiceLogger.error(String.format( "Invalid input while creating new customer %s ", customer));
        }
        return customerRepository.save(customer);
    }
}
