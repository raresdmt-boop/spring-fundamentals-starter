package com.example.fundamentals.ex06;

import org.springframework.stereotype.Component;

@Component
public class PaypalGateway implements PaymentGateway {

    @Override
    public String charge(int amountCents) {
        return "PAYPAL charged " + amountCents + " cents";
    }
}
