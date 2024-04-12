package com.example.eurder.utils.validator;

import com.example.eurder.domain.EntityModel;
import com.example.eurder.domain.eurder.Eurder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public abstract class ValidatorModel< Entity extends EntityModel> {

    private final Logger myLogger = LoggerFactory.getLogger(ValidatorModel.class);

    public boolean isValidCreation(Entity entity){
        return !isFieldEmptyOrNull(entity) && entity.getUuid() == null;
    }

    public boolean isUpdateValid(Entity entity){
        return !isFieldEmptyOrNull(entity) && entity.getUuid() != null;
    }

    protected abstract boolean isFieldEmptyOrNull(Entity entity);

    protected boolean isEmptyOrNull(String field){
        return field == null || field.isEmpty();
    }

    protected boolean isNull(Object object) {
        return object == null;
    }

    protected boolean isNotNull(Object object) {
        return object != null;
    }

    public void throwInvalidStateException(Entity entity, String type) {
        myLogger.error("Invalid entry for %s ");
        throw new IllegalStateException("Invalid " + (entity == null ? "NULL_ENTITY" : entity.getClass().getSimpleName())
                                        + " provided for " + type + ". Provided object: " + (entity == null ? null : entity.toString()));
    }

    protected abstract boolean isFieldEmptyOrNull(Eurder eurder);
}
