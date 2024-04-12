package com.example.eurder.abstraction.dto.eurder;

import java.util.Arrays;
import java.util.List;

public class EurderCreationDto {

    private List<ItemGroupDto> itemGroups;
    private String customerId;

    public EurderCreationDto() {
    }

    public EurderCreationDto withItemGroups(ItemGroupDto... itemGroups) {
        this.itemGroups = Arrays.asList(itemGroups);
        return this;
    }

    public EurderCreationDto withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public List<ItemGroupDto> getItemGroups() {
        return itemGroups;
    }

    public String getCustomerId() {
        return customerId;
    }
}