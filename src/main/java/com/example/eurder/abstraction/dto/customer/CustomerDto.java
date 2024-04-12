package com.example.eurder.abstraction.dto.customer;

import com.example.eurder.domain.user.userDetails.Role;

import java.util.UUID;

public class CustomerDto {

    private String uuid;
    private String firstName;
    private String lastName;
    private Role role;
    private EmailAdressDto emailAdress;
    private AdressDto adress;
    private PhoneNumberDto phoneNumber;

    public CustomerDto(){
    }

    public CustomerDto withId(UUID uuid) {
        this.uuid = String.valueOf(uuid);
        return this;
    }

    public CustomerDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerDto withRole(Role role){
        this.role = role;
        return this;
    }

    public CustomerDto withEmail(EmailAdressDto emailAdressDto) {
        this.emailAdress = emailAdressDto;
        return this;
    }

    public CustomerDto withAddress(AdressDto adress) {
        this.adress = adress;
        return this;
    }

    public CustomerDto withPhoneNumber(PhoneNumberDto phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }

    public EmailAdressDto getEmailAdress() {
        return emailAdress;
    }

    public AdressDto getAdress() {
        return adress;
    }

    public PhoneNumberDto getPhoneNumber() {
        return phoneNumber;
    }
}
