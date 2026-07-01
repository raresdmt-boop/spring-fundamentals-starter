package com.example.fundamentals.practica.p08;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Cerință:
// Publică un bean de tip List<String> numit "productCatalog" care conține
// exact: "phone", "laptop", "tablet". Bean-ul trebuie să fie injectabil în
// alte bean-uri prin @Qualifier("productCatalog").
//
// Hint: când publici un List ca @Bean, Spring distinge bean-ul după numele
// metodei, nu după tipul generic. Folosește @Qualifier la consumator.
@Component("productCatalog1")
public class ProductCatalogConfig {

    public List<String> productCatalog() {
        List<String> list = new ArrayList<>();
        list.add("phone");
        list.add("laptop");
        list.add("tablet");
        return list;
    }

}
