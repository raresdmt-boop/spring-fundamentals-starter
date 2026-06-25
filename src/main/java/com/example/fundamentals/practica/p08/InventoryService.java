package com.example.fundamentals.practica.p08;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

// Cerință:
// InventoryService trebuie să fie un bean Spring care primește în constructor
// lista publicată de ProductCatalogConfig (folosește @Qualifier("productCatalog")).
// count() întoarce numărul de produse din catalog.
@Component
public class InventoryService {

    private final ProductCatalogConfig productCatalogConfig;
    public InventoryService(@Qualifier("productCatalog") ProductCatalogConfig productCatalogConfig){
        this.productCatalogConfig = productCatalogConfig;
    }

    public int count() {
        return productCatalogConfig.productcatalog().size();
    }
}
