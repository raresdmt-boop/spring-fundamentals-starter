package com.example.fundamentals.practica.p08;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final List<String> catalog;

    public InventoryService(@Qualifier("productCatalog") List<String> catalog) {
        this.catalog = catalog;
    }

    public int count() {
        return catalog.size();
    }
}
