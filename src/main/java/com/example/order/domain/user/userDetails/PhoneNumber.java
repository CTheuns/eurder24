package com.example.order.domain.user.userDetails;

public final class PhoneNumber {

    private String phoneNumber;
    private String countryCode;

    public PhoneNumber(PhoneNumberBuilder phoneNumberBuilder) {
        this.phoneNumber = phoneNumberBuilder.phoneNumber;
        this.countryCode = phoneNumberBuilder.countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("phoneNumber='").append(phoneNumber).append('\'');
        sb.append(countryCode).append('\'');
        return sb.toString();
    }

    public static class PhoneNumberBuilder extends Builder<PhoneNumber>{
        private String phoneNumber;
        private String countryCode;

        private PhoneNumberBuilder(){
        }

        public static PhoneNumberBuilder phoneNumber(){
            return new PhoneNumberBuilder();
        }

        @Override
        public PhoneNumber build(){
            return new PhoneNumber(this);
        }

        public PhoneNumberBuilder withNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public PhoneNumberBuilder withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }
    }
}
