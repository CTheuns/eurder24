package com.example.order.abstraction.dto.customer;

public class EmailAdressDto {

    private String personalPart;
    private String domainName;

    public EmailAdressDto(){}

    public EmailAdressDto withPersonalPart(String personalPart) {
        this.personalPart = personalPart;
        return this;
    }

    public EmailAdressDto withDomainName(String domainName){
        this.domainName = domainName;
        return this;
    }

    public String getPersonalPart() {
        return personalPart;
    }

    public String getDomainName() {
        return domainName;
    }
}
