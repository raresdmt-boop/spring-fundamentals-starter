package com.example.fundamentals.practica.p06;

import com.example.fundamentals.practica.p01.WeatherService;
import org.springframework.stereotype.Component;

import java.time.Clock;

@Component
public class OrderProcessor {

    private final Clock clock;
    private final WeatherService weatherService;

    public OrderProcessor(Clock clock, WeatherService weatherService) {
        this.clock = clock;
        this.weatherService = weatherService;
    }

    public String summary() {
        return "Order on " + clock.getZone() + " | Temp: " + weatherService.currentTemperature();
    }
}
