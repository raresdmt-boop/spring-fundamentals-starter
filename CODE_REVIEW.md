# Code Review — rares-fundamentals-starter

Branch: `master` · Commit: `b30a174` ("exercitii terminate. final test had a problem")

## Stare pe module

Rulat local (`./mvnw test` în fiecare modul):

| Modul | Conținut | Rezultat |
|---|---|---|
| `practice` | ex01-07 + practica p01-10 + provocari c01-10 | ✅ verde |
| `exercitii-rezolvate` | demo instructor | ✅ verde |
| `challenge/starter` | notifications challenge | ❌ **1 test roșu** |

Exercițiile sunt terminate corect. Singura problemă e în `challenge/starter`.

---

## Challenge — testul final

Test care cade:

```
AuditLogInactiveProfileTest.auditLogIsNotInContextWithoutAuditProfile:38
expected: <true> but was: <false>
```

Sunt **două bug-uri cuplate** — trebuie reparate împreună.

### Bug 1 — `application.yaml` forțează profilul `audit` global

`src/main/resources/application.yaml`:

```yaml
spring:
  profiles:
    active: audit          # <-- strică testul "inactive"
```

Testul `AuditLogInactiveProfileTest` NU activează intenționat profilul `audit`,
ca să verifice că bean-ul `AuditLog` (`@Profile("audit")`) nu e în context.
`application.yaml` îl pornește pentru toată lumea → bean-ul apare →
`auditBeans.isEmpty()` e `false`.

**Fix:** șterge cele 3 linii `spring.profiles.active: audit`.
Fiecare test își alege profilul cu `@ActiveProfiles`; nu-l fixa global.

### Bug 2 (ascuns) — `Objects.requireNonNull(...getIfAvailable())`

`NotificationService.notify`:

```java
Objects.requireNonNull(auditLogProvider.getIfAvailable()).record(channel.send(message));
```

`ObjectProvider` există exact ca să tolereze bean-ul lipsă: fără profilul `audit`,
`getIfAvailable()` întoarce `null`, iar `requireNonNull` aruncă `NullPointerException`.
Acum nu se vede pentru că Bug 1 ține mereu bean-ul prezent — dar dacă scoți doar
linia din yaml, al doilea test din aceeași clasă (`notificationStillWorksWithoutAuditLog`)
pică cu NPE.

**Fix:** înlocuiește peste tot în `notify`:

```java
auditLogProvider.ifAvailable(log -> log.record(result));
```

în loc de `Objects.requireNonNull(auditLogProvider.getIfAvailable()).record(...)`.

### Rezultat după cele 2 fix-uri

Toate 6 testele din `challenge/starter` trec.

---

## Curățenie (nu blochează testele)

| # | Problemă | Unde | De ce contează |
|---|---|---|---|
| A | `channel.send(message)` apelat de 2 ori (o dată pt. record, o dată pt. return) | `notify`, toate ramurile | Un "send" e efect secundar — trimiți de două ori. Calculează o dată: `String result = channel.send(message); ...record(result); return result;` |
| B | Două `if` identice consecutive | `channel.name().equalsIgnoreCase(x)` și `x.equalsIgnoreCase(channel.name())` | `equalsIgnoreCase` e simetric → al doilea `if` e cod mort, șterge-l |
| C | Rutare pe primul cuvânt din mesaj (`message.split(" ")[0]`) | `notify` | Fragil: un mesaj care începe cu "sms…" ar fi rutat pe SMS. Nu e testat, doar semnalat |

---

## De reținut

`ObjectProvider<AuditLog>` în loc de `@Autowired AuditLog`:
`AuditLog` există doar sub profilul `audit`. Cu injecție directă contextul ar cere
bean-ul la pornire. `ObjectProvider` amână căutarea până la `notify()` și oferă
`ifAvailable(...)`, care rulează lambda doar dacă bean-ul chiar există — exact cazul
"opțional după profil".
