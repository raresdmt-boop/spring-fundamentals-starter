package com.example.debug.d07;

import org.springframework.context.annotation.Bean;

// 🐛 Aici e bug-ul.

public class ApiConfig {

    @Bean
    public ApiClient apiClient() {
        return new ApiClient("https://api.example.com");
    }
}
