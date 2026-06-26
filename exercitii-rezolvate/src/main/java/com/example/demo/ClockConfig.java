package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;

@Configuration
public class ClockConfig {

    @Bean
    public Clock clock() {
        Clock c = Clock.system(ZoneId.of("Europe/Bucharest"));
        System.out.println("    [@Bean] ClockConfig.clock() called — published Clock(zone=" + c.getZone() + ")");
        return c;
    }
}
