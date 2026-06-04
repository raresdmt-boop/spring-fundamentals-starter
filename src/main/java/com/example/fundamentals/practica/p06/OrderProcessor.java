package com.example.fundamentals.practica.p06;

import com.example.fundamentals.ex03.ClockConfig;
import com.example.fundamentals.practica.p01.WeatherService;

import java.time.Clock;

// Cerință:
// OrderProcessor trebuie să fie un bean Spring care primește prin constructor:
//   - un Clock (publicat în ex03/ClockConfig)
//   - un WeatherService (publicat în practica/p01)
// Metoda summary() întoarce: "Order on <zone-id> | Temp: <currentTemperature>"
// Exemplu: "Order on Europe/Bucharest | Temp: 20.0 C".
//
// Hint sintactic: clock.getZone() întoarce ZoneId; toString() pe el dă "Europe/Bucharest".

public class OrderProcessor {

    public String summary() {
        return null;
    }
}
