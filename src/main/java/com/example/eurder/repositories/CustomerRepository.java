package com.example.eurder.repositories;

import com.example.eurder.databases.CustomerDatabase;
import com.example.eurder.domain.user.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends RepositoryModel<Customer, CustomerDatabase>{

    public CustomerRepository(CustomerDatabase database) {
        super(database);
    }
}
