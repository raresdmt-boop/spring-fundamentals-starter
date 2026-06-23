package com.example.fundamentals.finala.f02;

// Cerință (vezi finala/README.md → F02):
// DiscountResolver primește toate reducerile, fiecare cunoscută printr-un nume:
// "none", "half", "tenoff". finalPrice(code, price) aplică reducerea cu numele
// `code`. Dacă `code` nu există, folosește o reducere de rezervă al cărei nume
// vine dintr-o proprietate de configurare (app.discount.fallback, default "none").
//   finalPrice("half", 100)   -> 50
//   finalPrice("tenoff", 100) -> 90
//   finalPrice("habar-n-am", 100) -> 100  (rezerva = none)

public class DiscountResolver {

    public int finalPrice(String code, int price) {
        return 0;
    }
}
