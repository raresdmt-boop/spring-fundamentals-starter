package com.example.fundamentals.provocari.c08;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
import java.util.Random;

@Configuration
public class RandomConfig {
    @Value("${app.random.seed}")
    private int seed;


    @Bean
    public Random random() {
        return new Random(seed);
    }

    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

}
