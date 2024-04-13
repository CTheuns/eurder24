package com.example.eurder.controllers;

import com.example.eurder.abstraction.dto.customer.CustomerDto;
import com.example.eurder.abstraction.mappers.customer.CustomerMapper;
import com.example.eurder.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers().stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public CustomerDto getCustomer(@PathVariable String id){
        return customerMapper.toDto(customerService.getCustomer(UUID.fromString(id)));
    }
}
