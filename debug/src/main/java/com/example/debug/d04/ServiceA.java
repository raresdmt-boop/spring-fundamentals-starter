package com.example.debug.d04;

import org.springframework.stereotype.Component;

@Component
public class ServiceA {

    private final ServiceB serviceB;

    // 🐛 Aici e bug-ul.
    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public String workA() {
        return "A:" + serviceB.label();
    }
}
