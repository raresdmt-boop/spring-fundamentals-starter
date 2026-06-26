package com.example.fundamentals.practica.p05;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RequestCounter {

    private int count = 0;

    public void increment() {
        count++;
    }

    public int current() {
        return count;
    }
}
