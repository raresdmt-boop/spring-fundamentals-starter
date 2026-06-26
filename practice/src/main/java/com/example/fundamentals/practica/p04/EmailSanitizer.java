package com.example.fundamentals.practica.p04;

// Cerință:
// EmailSanitizer trebuie să fie un bean Spring care la pornire (înainte de
// prima utilizare) populează un blacklist intern cu domeniile "gmail.com" și
// "yahoo.com". Metoda isAllowed(email) întoarce false dacă domeniul e în
// blacklist, true în rest. Domeniul = partea de după "@".

public class EmailSanitizer {

    public boolean isAllowed(String email) {
        return true;
    }
}
