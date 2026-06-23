package com.example.fundamentals.finala.f05;

// Cerință (vezi finala/README.md → F05 — BOSS):
// BillingEngine combină tot:
//   - primește TOATE regulile de facturare (BillingRule) din context;
//   - primește un MoneyFormatter; există două (RON și USD) — fără să ceri explicit
//     un nume, trebuie ales formatarea în RON ca implicit;
//   - citește procentul de taxă dintr-o proprietate (app.billing.tax-percent,
//     default 0);
//   - ruleCount() întoarce câte reguli au fost descoperite (calculat o dată,
//     după injecție).
// invoice(amountCents):
//   - dacă VREO regulă respinge suma -> "REJECTED";
//   - altfel total = sumă + taxa (procent), formatat cu formatarea implicită.
// Ex. cu tax-percent=10: invoice(100) -> "110 RON"; invoice(-5) -> "REJECTED";
//     invoice(2_000_000) -> "REJECTED" (peste limita de 1_000_000).

public class BillingEngine {

    public String invoice(int amountCents) {
        return null;
    }

    public int ruleCount() {
        return 0;
    }
}
