package com.example.fundamentals.ex04;

// TODO:
//   1. Marchează clasa cu @Component.
//   2. Pe parametrul `sender` din constructor adaugă @Qualifier("email") ca
//      Spring să injecteze EmailSender, nu SmsSender.
//      → Fără @Qualifier Spring vede două bean-uri de tip NotificationSender
//        și nu știe pe care să-l aleagă → aruncă NoUniqueBeanDefinitionException
//        la pornire.

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alerts {

    private final NotificationSender sender;

    public Alerts(@Qualifier("email") NotificationSender sender) {
        this.sender = sender;
    }

    public String raise(String alert) {
        return sender.send(alert);
    }
}
