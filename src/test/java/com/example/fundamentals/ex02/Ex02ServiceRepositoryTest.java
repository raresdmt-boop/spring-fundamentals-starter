package com.example.fundamentals.ex02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Ex02ServiceRepositoryTest.Config.class)
class Ex02ServiceRepositoryTest {

    @Configuration
    @ComponentScan
    static class Config {
    }

    @Autowired
    private Calculator calculator;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void calculatorAddsTwoNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertNotNull(calculator);
        assertEquals(5, result);
    }

    @Test
    void bookRepositoryReturnsThreeBooks() {
        // Arrange
        int expectedSize = 3;

        // Act
        List<String> books = bookRepository.findAll();

        // Assert
        assertNotNull(bookRepository);
        assertEquals(expectedSize, books.size());
    }
}
