package com.example.fundamentals.provocari.c08;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
import java.util.Random;

@Configuration
public class RandomConfig {

    @Bean
    public Random c08Random(@Value("${app.random.seed:0}") long seed) {
        return new Random(seed);
    }

    @Bean
    public DateTimeFormatter c08DateFormatter(@Value("${app.date.pattern:yyyy-MM-dd}") String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }
}
