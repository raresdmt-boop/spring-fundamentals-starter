package com.example.fundamentals.practica.p04;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Cerință:
// EmailSanitizer trebuie să fie un bean Spring care la pornire (înainte de
// prima utilizare) populează un blacklist intern cu domeniile "gmail.com" și
// "yahoo.com". Metoda isAllowed(email) întoarce false dacă domeniul e în
// blacklist, true în rest. Domeniul = partea de după "@".
@Component
public class EmailSanitizer {

    public boolean isAllowed(String email) {
        String domain = email.split("@")[1];
        return !blacklist.contains(domain);
    }

    List<String> blacklist = new ArrayList<>();

    @PostConstruct
    public void init(){
        blacklist.add("gmail.com");
        blacklist.add("yahoo.com");
    }
}
