package com.example.eurder.domain.user.userDetails;

public final class EmailAdress {

    private String personalPart;
    private String domainName;

    private EmailAdress(EmailBuilder emailBuilder){
        this.personalPart = emailBuilder.personalPart;
        this.domainName =emailBuilder.domainName;
    }

    public String getPersonalPart() {
        return personalPart;
    }

    public String getDomainName() {
        return domainName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(personalPart);
        sb.append(domainName);
        return sb.toString();
    }

    public static class EmailBuilder extends Builder<EmailAdress> {

        private String personalPart;
        private String domainName;

        private EmailBuilder() {
        }

        public static EmailBuilder email() {
            return new EmailBuilder();
        }

        @Override
        public EmailAdress build() {
            return new EmailAdress(this);
        }

        public EmailBuilder withPersonalPart(String personalPart) {
           this.personalPart = personalPart;
            return this;
        }

       public EmailBuilder withDomainName(String domainName){
            this.domainName = domainName;
            return this;
       }
    }
}
