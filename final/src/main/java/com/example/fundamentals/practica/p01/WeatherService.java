package com.example.fundamentals.practica.p01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final String unit;

    public WeatherService(@Value("${app.weather.unit:C}") String unit) {
        this.unit = unit;
    }

    public String currentTemperature() {
        return "20.0 " + unit;
    }
}
