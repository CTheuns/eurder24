package com.example.order.controllers;

import com.example.order.abstraction.dto.customer.CustomerDto;
import com.example.order.abstraction.mappers.customer.CustomerMapper;
import com.example.order.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "customer")
public class CustomerController {

private CustomerService customerService;
private CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public CustomerDto createNewCustomer(@RequestBody CustomerDto customerDto){
       return   customerMapper.toDto(customerService.createNewCustomer(customerMapper.ToDomain(customerDto)));
    }
}
