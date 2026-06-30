package com.example.fundamentals.ex06;

// TODO: Marchează clasa cu @Component (fără @Primary).

import org.springframework.stereotype.Component;

@Component("paypal")
public class PaypalGateway implements PaymentGateway {

    @Override
    public String charge(int amountCents) {
        return "PAYPAL charged " + amountCents + " cents";
    }
}
