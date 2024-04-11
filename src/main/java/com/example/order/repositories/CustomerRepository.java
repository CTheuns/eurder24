package com.example.order.repositories;

import com.example.order.databases.CustomerDatabase;
import com.example.order.domain.user.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

CustomerDatabase database;

    public CustomerRepository(CustomerDatabase database) {
        this.database = database;
    }

    public Customer save(Customer customer) {
        customer.generateId();
        database.save(customer);
        return customer;
    }
}
