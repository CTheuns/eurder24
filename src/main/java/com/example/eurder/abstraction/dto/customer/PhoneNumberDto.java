package com.example.eurder.abstraction.dto.customer;

public class PhoneNumberDto {

    String phoneNumber;
    String countryCode;

    public PhoneNumberDto(){}

    public PhoneNumberDto withNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PhoneNumberDto withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
