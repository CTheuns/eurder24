package com.example.order.databases;

import com.example.order.domain.user.Customer;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class CustomerDatabase {

    private Map<UUID, Customer> customers;

    public CustomerDatabase() {
        customers = new HashMap<>();
    }

    public Map<UUID, Customer> getAll() {
        return Collections.unmodifiableMap(customers);
    }

    public void save(Customer customer) {
        customers.put(customer.getUuid(), customer);
    }
}
