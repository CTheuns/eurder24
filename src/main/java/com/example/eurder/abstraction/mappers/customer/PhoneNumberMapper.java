package com.example.eurder.abstraction.mappers.customer;

import com.example.eurder.abstraction.dto.customer.PhoneNumberDto;
import com.example.eurder.domain.user.userDetails.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberMapper {

    public PhoneNumberDto toDto(PhoneNumber phoneNumber){
        return new PhoneNumberDto()
                .withNumber(phoneNumber.getPhoneNumber())
                .withCountryCode(phoneNumber.getCountryCode());
    }

    public PhoneNumber toDomain(PhoneNumberDto phoneNumberDto){
        return PhoneNumber.PhoneNumberBuilder.phoneNumber()
                .withNumber(phoneNumberDto.getPhoneNumber())
                .withCountryCode(phoneNumberDto.getCountryCode())
                .build();
    }
}
