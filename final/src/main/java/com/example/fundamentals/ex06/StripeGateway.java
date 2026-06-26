package com.example.fundamentals.ex06;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StripeGateway implements PaymentGateway {

    @Override
    public String charge(int amountCents) {
        return "STRIPE charged " + amountCents + " cents";
    }
}
