package com.example.eurder.repositories;

import com.example.eurder.domain.EntityModel;
import com.example.eurder.utils.DataBaseModel;

import java.util.Map;
import java.util.UUID;

public class RepositoryModel <Entity extends EntityModel, DataBase extends DataBaseModel<Entity>> {

    private DataBase database;

    public RepositoryModel(DataBase database){
        this.database = database;
    }

    protected DataBase getDatabase(){
        return database;
    }

    public Entity save(Entity entity){
        entity.generateId();
        database.save(entity);
        return entity;
    }

    public Entity update(Entity entity){
        database.save(entity);
        return entity;
    }

    public Map<UUID, Entity> getAll(){
        return database.getAll();
    }

    public Entity get(UUID entityId){
        return database.getAll().get(entityId);
    }
}
