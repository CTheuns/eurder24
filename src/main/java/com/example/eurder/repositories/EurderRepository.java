package com.example.eurder.repositories;

import com.example.eurder.databases.DataBaseModel;
import com.example.eurder.databases.EurderDataBase;
import com.example.eurder.domain.eurder.Eurder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class EurderRepository extends RepositoryModel<Eurder, EurderDataBase>{

    public EurderRepository(EurderDataBase database) {
        super(database);
    }

    @Override
    public Eurder save(Eurder entity) {
        Eurder savedOrder = super.save(entity);
        savedOrder.getOrderItems();
        return savedOrder;
    }

    public List<Eurder> getOrdersForCustomer(UUID customerId) {
        return getDatabase().getAll().values().stream()
                            .filter(order -> order.getCustomerId().equals(customerId))
                            .collect(Collectors.toList());
    }
}
