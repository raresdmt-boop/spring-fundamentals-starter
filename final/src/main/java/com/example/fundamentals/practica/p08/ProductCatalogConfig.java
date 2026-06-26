package com.example.fundamentals.practica.p08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductCatalogConfig {

    @Bean
    public List<String> productCatalog() {
        return List.of("phone", "laptop", "tablet");
    }
}
