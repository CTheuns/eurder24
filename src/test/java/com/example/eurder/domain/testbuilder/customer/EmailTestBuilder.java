package com.example.eurder.domain.testbuilder.customer;

import com.example.eurder.domain.user.userDetails.Builder;
import com.example.eurder.domain.user.userDetails.EmailAdress;
import com.example.eurder.domain.user.userDetails.EmailAdress.EmailBuilder;

public class EmailTestBuilder extends Builder<EmailAdress> {

    private EmailBuilder emailBuilder;

    private EmailTestBuilder(EmailBuilder emailBuilder) {
        this.emailBuilder = emailBuilder;
    }

    public static EmailTestBuilder anEmptyEmail() {
        return new EmailTestBuilder(EmailBuilder.email());
    }

    public static EmailTestBuilder anEmail() {
        return new EmailTestBuilder(EmailBuilder.email()
                                                .withPersonalPart("test")
                                                .withDomainName("testmail.be"));
    }

    @Override
    public EmailAdress build() {
        return emailBuilder.build();
    }

    public EmailTestBuilder withPersonalPart(String localPart) {
        emailBuilder.withPersonalPart(localPart);
        return this;
    }

    public EmailTestBuilder withDomainName(String domain) {
        emailBuilder.withDomainName(domain);
        return this;
    }

}
