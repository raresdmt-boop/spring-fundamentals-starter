# Finala — provocarea de final

5 exerciții care **combină** mai multe concepte într-unul singur. Fără hinturi
despre adnotări — doar cerința funcțională. Testele sunt sursa de adevăr: dacă
trec, e bine. Aici nu mai e despre un singur concept, ci despre a le pune
împreună.

**Cum lucrezi:** modifică DOAR fișierele din `main/` (clasele scheleton). NU
modifica testele. Implementările-frunză (ex. `EmailValidator`-style) au deja
logica de business scrisă — ce lipsește e wiring-ul Spring și clasa „creier”
(agregatorul), care e goală.

```bash
./mvnw test -Dtest='F01*'   # un singur exercițiu
./mvnw test -Dtest='F0*'    # toată finala
```

Tot ce ai nevoie ca teorie e în `TEORIE.md` + ce ai învățat la `practica` și
`provocari`. Două lucruri sunt ușor peste teorie (caută-le singur): **ordonarea**
unei liste de bean-uri (F01) și **resetarea** la oprirea contextului (F03).

---

## F01 — Middleware Chain
Combină: listă de bean-uri + ordine + inițializare la pornire.

Există interfața `Middleware` cu `handle(payload)`. Trei implementări adaugă câte
o etichetă: `AuthMiddleware` → `[auth]`, `LogMiddleware` → `[log]`,
`CompressMiddleware` → `[zip]`.

`MiddlewareChain` primește **toate** middleware-urile și le aplică pe payload în
ordinea: auth, apoi log, apoi zip.
- `process("REQ")` → `"REQ[auth][log][zip]"`
- `size()` → `3` (calculat o singură dată, după ce injecția s-a terminat)

> Ordinea în care Spring îți dă bean-urile dintr-o listă **nu** e garantată din
> oficiu. Trebuie să o impui tu.

## F02 — Discount Resolver
Combină: căutare după nume + valoare din configurare + rezervă.

Interfața `Discount` cu `apply(price)`. Trei reduceri, fiecare cu un nume:
`none` (preț neschimbat), `half` (preț / 2), `tenoff` (preț − 10).

`DiscountResolver.finalPrice(code, price)` aplică reducerea cu numele `code`.
Dacă `code` nu există, folosește o reducere de rezervă al cărei nume vine din
proprietatea `app.discount.fallback` (default `none`).
- `finalPrice("half", 100)` → `50`
- `finalPrice("tenoff", 100)` → `90`
- `finalPrice("habar-n-am", 100)` → `100` (rezerva = none)

## F03 — Metrics Buffer
Combină: valoare din configurare + inițializare la pornire + curățare la oprire.

`MetricsBuffer` ține eșantioane numerice.
- `isReady()` devine `true` după pornirea contextului.
- `record(v)` adaugă un eșantion, dar nu peste capacitatea maximă citită din
  `app.metrics.capacity` (default `3`). `count()` = câte sunt ținute.
- la **oprirea** contextului: `isFlushed()` devine `true` și `count()` → `0`.

## F04 — Export Service
Combină: căutare după nume + bean activ doar pe un profil.

Interfața `Exporter` cu `export(data)`. Trei exportatoare, fiecare cu un nume:
`json` → `{data}`, `csv` → `csv:data`, `xml` → `<data>`.

`ExportService`:
- `supports(format)` → `true` dacă există un exportator cu acel nume.
- `run(format, data)` deleagă către exportatorul cu numele `format`.
- `formatCount()` → câte exportatoare există în context.

**Cheia:** `xml` trebuie să existe DOAR când e activ profilul `enterprise`. Fără
profil: `supports("xml")` = `false`, `formatCount()` = `2`. Cu profilul activ:
`supports("xml")` = `true`, `formatCount()` = `3`.

## F05 — Billing Engine (BOSS)
Combină: listă de bean-uri + valoare din configurare + implementare implicită +
inițializare la pornire.

`BillingRule.ok(amount)` — două reguli: `PositiveAmountRule` (suma > 0) și
`MaxAmountRule` (suma ≤ 1_000_000).
`MoneyFormatter.format(cents)` — două formatări: RON (`"<n> RON"`) și USD
(`"$<n>"`).

`BillingEngine`:
- primește **toate** regulile; `ruleCount()` = câte sunt (calculat o dată, după
  injecție).
- primește un `MoneyFormatter`; deși există două, fără să ceri explicit un nume
  trebuie ales **RON** ca implicit.
- citește procentul de taxă din `app.billing.tax-percent` (default `0`).
- `invoice(amount)`: dacă vreo regulă respinge suma → `"REJECTED"`; altfel
  total = sumă + taxă, formatat în RON.

Cu `tax-percent=10`:
- `invoice(100)` → `"110 RON"`
- `invoice(-5)` → `"REJECTED"`
- `invoice(2_000_000)` → `"REJECTED"`
- `ruleCount()` → `2`

---

## Definition of Done
- [ ] `./mvnw test -Dtest='F0*'` — 14/14 GREEN
- [ ] Poți explica, pentru fiecare exercițiu, CE combinație de adnotări ai
      folosit și DE CE.
