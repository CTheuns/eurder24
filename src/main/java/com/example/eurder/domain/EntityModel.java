package com.example.eurder.domain;

import java.util.UUID;

public abstract class EntityModel {

    private UUID uuid;

    protected EntityModel(UUID uuid){
        this.uuid = uuid;
    }

    public void generateId() {
        if (uuid != null){
            throw new IllegalStateException("Generating an ID when there already is " +
                                            "one (" + uuid + ") is not allowed.");
        }
        uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }
}
