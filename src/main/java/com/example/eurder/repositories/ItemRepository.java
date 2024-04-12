package com.example.eurder.repositories;

import com.example.eurder.databases.ItemDataBase;
import com.example.eurder.domain.item.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository extends RepositoryModel<Item, ItemDataBase> {

    public ItemRepository(ItemDataBase database) {
        super(database);
    }
}
