package com.example.fundamentals.practica.p04;

// Cerință:
// EmailSanitizer trebuie să fie un bean Spring care la pornire (înainte de
// prima utilizare) populează un blacklist intern cu domeniile "gmail.com" și
// "yahoo.com". Metoda isAllowed(email) întoarce false dacă domeniul e în
// blacklist, true în rest. Domeniul = partea de după "@".

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EmailSanitizer {

    private final List<String> blacklist;

    public EmailSanitizer(List<String> blacklist) {
        this.blacklist = blacklist;
    }

    public boolean isAllowed(String email) {

        String domain = email.split("@")[1];
        return !blacklist.contains(domain);
    }

    @PostConstruct
    private void warmUp(){
        blacklist.add("yahoo.com");
        blacklist.add("gmail.com");
    }
}
