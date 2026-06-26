# Challenge — Sistem de notificări

Capstone pentru L01: combini tot (interfață + `@Component`, `@Value` din yaml, `@PostConstruct`, `@Profile`, injecție `List<T>`, dependență opțională cu `ObjectProvider`).

Primești **schelet + teste de acceptanță**. Clasele există ca *stub-uri* (`throw new UnsupportedOperationException("TODO")`, fără adnotări Spring). Le implementezi tu până trec cele **6 teste**.

```bash
./mvnw -pl challenge/starter test     # 6 teste RED → le faci GREEN (din rădăcina proiectului)
```

## Ce ai de implementat (`src/main/java/com/example/notifications/`)

| Clasă | Ce trebuie |
|---|---|
| `NotificationChannel` | interfața — deja gata (`name()`, `send(message)`) |
| `EmailNotifier` / `SmsNotifier` / `SlackNotifier` | adnotează-le ca bean-uri; `send()` întoarce `"EMAIL: <msg>"` / `"SMS: <msg>"` / `"SLACK: <msg>"`; `name()` întoarce `email`/`sms`/`slack` |
| `SpamFilter` | blacklist (`lottery`, `winner`, `prize`) populat **la pornire** (`@PostConstruct`); `isSpam(msg)` case-insensitive |
| `AuditLog` | activ **doar** pe profilul `audit` (`@Profile("audit")`); `record(...)` + `entries()` |
| `NotificationService` | rutează prin canalul din `app.notifications.default-channel`; blochează spam (`"BLOCKED: spam detected"`); înregistrează în `AuditLog` dacă există |

## Comportamentul cerut (verificat de teste)

1. **Canal default din config** — `NotificationService.notify(msg)` trimite prin canalul din yaml. Schimbi `app.notifications.default-channel` din `email` în `sms` → comportamentul se schimbă fără să rescrii cod.
2. **Spam** — mesaj care conține un cuvânt din blacklist (case-insensitive) → `"BLOCKED: spam detected"`, fără să se trimită.
3. **Audit opțional** — pe profilul `audit`, fiecare notificare trimisă (NU cele blocate) se înregistrează în `AuditLog.entries()`. Fără profil, `AuditLog` **nu există** în context, iar `notify(...)` merge în continuare.

## Testele (deja scrise — nu le modifici)

| Test | Verifică |
|---|---|
| `NotificationServiceTest` | canal default `email` + spam blocat |
| `NotificationServiceWithSmsTest` | schimbarea canalului prin config (`sms`) — `@TestPropertySource` |
| `AuditLogActiveProfileTest` | audit înregistrează — `@ActiveProfiles("audit")` |
| `AuditLogInactiveProfileTest` | fără profil, `AuditLog` lipsește din context; `notify` tot merge |

## Constrângeri

- Doar **constructor injection** (fără `@Autowired` pe câmp).
- Mesaje tehnice (excepții, log-uri) în engleză.
- Doar adnotări acoperite în L01 (fără `@EventListener`, `@Async`, etc.).

## Hint-uri (când te blochezi)

<details>
<summary>Cum rutez către canalul ales din yaml?</summary>

`NotificationService` cere prin constructor `List<NotificationChannel>` (Spring îți dă toate cele 3 impls) și le mapezi după `name()` într-un `Map<String, NotificationChannel>`. Canalul default vine din `@Value("${app.notifications.default-channel}")`; faci lookup în map.
</details>

<details>
<summary>Cum fac AuditLog opțional (poate lipsi din context)?</summary>

Injectează `ObjectProvider<AuditLog>` în constructor și folosește `auditLogProvider.getIfAvailable()` — întoarce `null` când profilul `audit` nu e activ. Vezi și `applicationContext.getBeansOfType(AuditLog.class)` în [`../teorie/EXERCITII-TEORIE.md`](../teorie/EXERCITII-TEORIE.md).
</details>
