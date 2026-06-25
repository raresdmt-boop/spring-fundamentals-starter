package com.example.fundamentals.practica.p01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Cerință:
// Clasa trebuie să fie un bean Spring. Metoda currentTemperature() întoarce
// șirul "20.0 <UNIT>" — unde <UNIT> e valoarea proprietății `app.weather.unit`
// din application.yaml. Dacă proprietatea lipsește, foloseste "C" ca default.
@Component
public class WeatherService {

    private final String unit;

    public WeatherService(@Value("${app.weather.unit:C}") String unit) {
        this.unit = unit;
    }

    public String currentTemperature() {
        return "20.0 " + unit;
    }
}
