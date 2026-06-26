package com.example.debug.d05;

import org.springframework.boot.autoconfigure.SpringBootApplication;

// 🐛 Aici e bug-ul.
@SpringBootApplication(scanBasePackages = "com.example.debug.d05")
public class D05Application {
}
