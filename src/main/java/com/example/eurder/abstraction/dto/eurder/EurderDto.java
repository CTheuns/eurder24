package com.example.eurder.abstraction.dto.eurder;

import com.example.eurder.abstraction.dto.customer.AdressDto;

import java.util.Arrays;
import java.util.List;

public class EurderDto {

    private String orderId;
    private List<ItemGroupDto> itemGroups;
    private AdressDto adress;

    public EurderDto() {
    }

    public EurderDto withItemGroups(ItemGroupDto... itemGroups) {
        this.itemGroups = Arrays.asList(itemGroups);
        return this;
    }

    public EurderDto withAddress(AdressDto adress) {
        this.adress = adress;
        return this;
    }

    public EurderDto withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public List<ItemGroupDto> getItemGroups() {
        return itemGroups;
    }

    public AdressDto getAdress() {
        return adress;
    }

    public String getOrderId() {
        return orderId;
    }
}
