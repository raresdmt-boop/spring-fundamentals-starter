package com.example.fundamentals.practica.p03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateFormatConfig {

    @Bean
    public DateTimeFormatter dateFormatter(@Value("${app.formatter.pattern}") String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }
}
