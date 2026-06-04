package com.example.fundamentals.ex06;

// TODO:
//   1. Marchează clasa cu @Component ca să fie descoperită la scan.
//   2. Adaugă și @Primary peste @Component. Spring va alege această implementare
//      ca default când există mai multe bean-uri de tip PaymentGateway și
//      consumatorul NU specifică @Qualifier.

public class StripeGateway implements PaymentGateway {

    @Override
    public String charge(int amountCents) {
        return "STRIPE charged " + amountCents + " cents";
    }
}
