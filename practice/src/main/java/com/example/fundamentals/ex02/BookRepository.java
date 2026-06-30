package com.example.fundamentals.ex02;

import org.springframework.stereotype.Repository;

import java.util.List;

// TODO: Marchează clasa cu @Repository.
// @Repository e o specializare semantică a @Component pentru clase care acces-
// ează date (DB, fișiere, API extern). În plus față de @Component, declanșează
// traducerea excepțiilor de persistență la DataAccessException.
@Repository
public class BookRepository {

    public List<String> findAll() {
        return List.of("Clean Code", "Effective Java", "Refactoring");
    }
}
