package com.example.fundamentals.practica.p07;

// Cerință:
// AuditTrail trebuie să fie un bean Spring activ DOAR când profilul "audit" e
// activ. Metoda log(event) întoarce: "AUDIT: <event>".
// Când profilul "audit" nu e activ, bean-ul nu există în context.

public class AuditTrail {

    public String log(String event) {
        return null;
    }
}
