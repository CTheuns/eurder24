package com.example.eurder.abstraction.mappers.customer;

import com.example.eurder.abstraction.dto.customer.EmailAdressDto;
import com.example.eurder.domain.user.userDetails.EmailAdress;
import org.springframework.stereotype.Component;

@Component
public class EmailAdressMapper {

    public EmailAdressDto toDto(EmailAdress emailAdress){
        return new EmailAdressDto()
                .withPersonalPart(emailAdress.getPersonalPart())
                .withDomainName(emailAdress.getDomainName());
    }

    public EmailAdress toDomain(EmailAdressDto emailAdressDto){
        return EmailAdress.EmailBuilder.email()
                .withPersonalPart(emailAdressDto.getPersonalPart())
                .withDomainName(emailAdressDto.getDomainName())
                .build();
    }
}
