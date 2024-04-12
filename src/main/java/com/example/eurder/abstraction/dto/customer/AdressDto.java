package com.example.eurder.abstraction.dto.customer;

public class AdressDto {

    private String streetName;
    private String houseNumber;
    private String houseNumberExtension;
    private String postalCode;
    private String city;
    private String country;

    public AdressDto() {}

    public AdressDto withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public AdressDto withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public AdressDto withHouseNumberExtension(String houseNumberExtension) {
        this.houseNumberExtension = houseNumberExtension;
        return this;
    }

    public AdressDto withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AdressDto withCity(String city) {
        this.city = city;
        return this;
    }

    public AdressDto withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getHouseNumberExtension() {
        return houseNumberExtension;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
