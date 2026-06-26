package com.example.fundamentals.ex06;

// TODO: Marchează clasa cu @Component (fără @Primary).

public class PaypalGateway implements PaymentGateway {

    @Override
    public String charge(int amountCents) {
        return "PAYPAL charged " + amountCents + " cents";
    }
}
