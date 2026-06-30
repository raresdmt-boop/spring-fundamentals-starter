package com.example.fundamentals.ex06;

import org.springframework.stereotype.Component;

// TODO: Marchează clasa cu @Component.
// Observă: în constructor cerem PaymentGateway FĂRĂ @Qualifier. Pentru că
// StripeGateway e @Primary, Spring îl alege automat ca default — chiar dacă
// există și PaypalGateway în context.
@Component
public class Checkout {

    private final PaymentGateway gateway;

    public Checkout(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public String pay(int amountCents) {
        return gateway.charge(amountCents);
    }
}
