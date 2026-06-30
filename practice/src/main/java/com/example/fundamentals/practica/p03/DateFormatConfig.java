package com.example.fundamentals.practica.p03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

// Cerință:
// Publică un bean de tip java.time.format.DateTimeFormatter, configurat cu
// pattern-ul citit din proprietatea `app.formatter.pattern` (din application.yaml).
// Bean-ul trebuie să poată fi injectat oriunde declari `DateTimeFormatter`.
@Component
public class DateFormatConfig {

    private final String pattern;

    public DateFormatConfig(@Value("${app.formatter.pattern}") String pattern) {
        this.pattern = pattern;
    }

    @Bean
    public DateTimeFormatter formatter() {
        return DateTimeFormatter.ofPattern(pattern);
    }

}
