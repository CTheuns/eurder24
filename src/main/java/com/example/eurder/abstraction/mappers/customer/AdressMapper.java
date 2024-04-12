package com.example.eurder.abstraction.mappers.customer;

import com.example.eurder.abstraction.dto.customer.AdressDto;
import com.example.eurder.domain.user.userDetails.Adress;
import org.springframework.stereotype.Component;

@Component
public class AdressMapper {

    public AdressDto toDto(Adress adress) {
        return new AdressDto()
                .withStreetName(adress.getStreetName())
                .withHouseNumber(adress.getHouseNumber())
                .withHouseNumberExtension(adress.getHouseNumberExtension())
                .withPostalCode(adress.getPostalCode())
                .withCity(adress.getCity())
                .withCountry(adress.getCountry());
    }

    public Adress toDomain(AdressDto adressDto) {
        return Adress.AdressBuilder.adress()
                                   .withStreetName(adressDto.getStreetName())
                                   .withHouseNumber(adressDto.getHouseNumber())
                                   .withHouseNumberExtension(adressDto.getHouseNumberExtension())
                                   .withPostalCode(adressDto.getPostalCode())
                                   .withCity(adressDto.getCity())
                                   .withCountry(adressDto.getCountry())
                                   .build();
    }
}
