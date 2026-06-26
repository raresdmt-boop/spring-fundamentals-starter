package com.example.fundamentals.ex02;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    public List<String> findAll() {
        return List.of("Clean Code", "Effective Java", "Refactoring");
    }
}
