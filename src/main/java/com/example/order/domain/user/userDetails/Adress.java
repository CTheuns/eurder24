package com.example.order.domain.user.userDetails;

public final class Adress {

    private String streetName;
    private String houseNumber;
    private String houseNumberExtension;
    private String postalCode;
    private String city;
    private String country;

    public Adress(AdressBuilder adressBuilder) {
        this.streetName = adressBuilder.streetName;
        this.houseNumber = adressBuilder.houseNumber;
        this.houseNumberExtension = adressBuilder.houseNumberExtension;
        this.postalCode = adressBuilder.postalCode;
        this.city = adressBuilder.city;
        this.country = adressBuilder.country;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(streetName).append('\'');
        sb.append(houseNumber);
        sb.append(" ").append(houseNumberExtension).append('\'');
        sb.append(postalCode).append('\'');
        sb.append(city).append('\'');
        sb.append(country).append('\'');
        return sb.toString();
    }

    public static class AdressBuilder extends Builder<Adress> {

        private String streetName;
        private String houseNumber;
        private String houseNumberExtension;
        private String postalCode;
        private String city;
        private String country;

        private AdressBuilder() {}

        public static AdressBuilder adress() {return new AdressBuilder();}

        @Override
        public Adress build() {
            return new Adress(this);
        }

        public AdressBuilder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public AdressBuilder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public AdressBuilder withHouseNumberExtension(String houseNumberExtension) {
            this.houseNumberExtension = houseNumberExtension;
            return this;
        }

        public AdressBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AdressBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AdressBuilder withCountry(String country) {
            this.country = country;
            return this;
        }
    }
}
