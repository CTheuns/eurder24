package com.example.eurder.domain.testbuilder.customer;

import com.example.eurder.domain.user.userDetails.Builder;
import com.example.eurder.domain.user.userDetails.PhoneNumber;
import com.example.eurder.domain.user.userDetails.PhoneNumber.PhoneNumberBuilder;

public class PhoneNumberTestBuilder extends Builder<PhoneNumber> {

    private final PhoneNumberBuilder phoneNumberBuilder;

    private PhoneNumberTestBuilder(PhoneNumberBuilder phoneNumberBuilder) {
        this.phoneNumberBuilder = phoneNumberBuilder;
    }

    public static PhoneNumberTestBuilder anEmptyPhoneNumber() {
        return new PhoneNumberTestBuilder(PhoneNumberBuilder.phoneNumber());
    }

    public static PhoneNumberTestBuilder aPhoneNumber(){
        return new PhoneNumberTestBuilder(PhoneNumberBuilder.phoneNumber()
                                                  .withNumber("12300")
                                                  .withCountryCode("++32")
        );
    }

    @Override
    public PhoneNumber build() {
        return phoneNumberBuilder.build();
    }

    public PhoneNumberTestBuilder withNumber(String number) {
        phoneNumberBuilder.withNumber(number);
        return this;
    }

    public PhoneNumberTestBuilder withCountryCode(String countryCode) {
        phoneNumberBuilder.withCountryCode(countryCode);
        return this;
    }
}
