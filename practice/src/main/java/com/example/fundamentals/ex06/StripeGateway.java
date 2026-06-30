package com.example.fundamentals.ex06;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// TODO:
//   1. Marchează clasa cu @Component ca să fie descoperită la scan.
//   2. Adaugă și @Primary peste @Component. Spring va alege această implementare
//      ca default când există mai multe bean-uri de tip PaymentGateway și
//      consumatorul NU specifică @Qualifier.
@Component("stripe")
@Primary
public class StripeGateway implements PaymentGateway {

    @Override
    public String charge(int amountCents) {
        return "STRIPE charged " + amountCents + " cents";
    }
}
