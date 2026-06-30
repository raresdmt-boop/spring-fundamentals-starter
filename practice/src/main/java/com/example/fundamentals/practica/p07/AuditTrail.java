package com.example.fundamentals.practica.p07;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// Cerință:
// AuditTrail trebuie să fie un bean Spring activ DOAR când profilul "audit" e
// activ. Metoda log(event) întoarce: "AUDIT: <event>".
// Când profilul "audit" nu e activ, bean-ul nu există în context.
@Configuration
@Profile("audit")
public class AuditTrail {

    public String log(String event) {
        return "AUDIT: "+ event;
    }
}
