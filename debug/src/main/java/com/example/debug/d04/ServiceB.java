package com.example.debug.d04;

import org.springframework.stereotype.Component;

@Component
public class ServiceB {

    private final ServiceA serviceA;

    // 🐛 Aici e bug-ul (în pereche cu ServiceA).
    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public String label() {
        return "B";
    }
}
