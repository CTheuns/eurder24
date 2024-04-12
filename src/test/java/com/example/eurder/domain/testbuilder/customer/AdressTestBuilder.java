package com.example.eurder.domain.testbuilder.customer;

import com.example.eurder.domain.user.userDetails.Adress;
import com.example.eurder.domain.user.userDetails.Adress.AdressBuilder;
import com.example.eurder.domain.user.userDetails.Builder;

public class AdressTestBuilder extends Builder<Adress> {

    private AdressBuilder adressBuilder;

    private AdressTestBuilder(AdressBuilder adressBuilder) {
        this.adressBuilder = adressBuilder;}

    public static AdressTestBuilder anEmptyAddress() {
        return new AdressTestBuilder(AdressBuilder.adress());
    }

    public static AdressTestBuilder anAdress(){
        return new AdressTestBuilder(AdressBuilder.adress()
                                             .withStreetName("someStreet")
                                             .withHouseNumber("2")
                                             .withHouseNumberExtension("A")
                                             .withPostalCode("2040")
                                             .withCity("somewhere")
                                             .withCountry("anywhere")
        );
    }

    @Override
    public Adress build() {
        return adressBuilder.build();
    }

    public AdressTestBuilder withStreetName(String streetName) {
        adressBuilder.withStreetName(streetName);
        return this;
    }

    public AdressTestBuilder withHouseNumber(String houseNumber) {
        adressBuilder.withHouseNumber(houseNumber);
        return this;
    }

    public AdressTestBuilder withHouseNumberExtencion(String extencion){
        adressBuilder.withHouseNumberExtension(extencion);
        return this;
    }

    public AdressTestBuilder withPostalCode(String postalCode) {
        adressBuilder.withPostalCode(postalCode);
        return this;
    }

    public AdressTestBuilder withCity(String city){
        adressBuilder.withCity(city);
        return this;
    }

    public AdressTestBuilder withCountry(String country) {
        adressBuilder.withCountry(country);
        return this;
    }

}
