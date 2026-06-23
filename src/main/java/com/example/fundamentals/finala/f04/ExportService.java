package com.example.fundamentals.finala.f04;

// Cerință (vezi finala/README.md → F04):
// ExportService primește toate exportatoarele disponibile, fiecare cunoscut
// printr-un nume: "json", "csv" și "xml".
//   - supports(format) = true dacă există un exportator cu acel nume.
//   - run(format, data) deleagă către exportatorul cu numele `format`.
//   - formatCount() = câte exportatoare există în context.
// ATENȚIE: exportatorul "xml" trebuie să existe DOAR când e activ profilul
// "enterprise". Fără acel profil, supports("xml") = false, iar formatCount() = 2.

public class ExportService {

    public boolean supports(String format) {
        return false;
    }

    public String run(String format, String data) {
        return null;
    }

    public int formatCount() {
        return 0;
    }
}
