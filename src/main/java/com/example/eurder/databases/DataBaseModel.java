package com.example.eurder.utils;

import com.example.eurder.domain.EntityModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class DataBaseModel <Entity extends EntityModel>{

    private Map<UUID, Entity> entities;

    public DataBaseModel() {
        entities = new HashMap<>();
    }

    @SafeVarargs
    final void populate(Entity... entities){
        this.entities = Arrays.stream(entities)
                .collect(Collectors.toMap(EntityModel::getUuid, entity -> entity));
    }

    public Map<UUID, Entity> getAll(){
        return Collections.unmodifiableMap(entities);
    }

    public void save(Entity entity){
        entities.put(entity.getUuid(), entity);
    }
}
