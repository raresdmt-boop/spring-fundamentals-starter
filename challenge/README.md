# Challenge — Sistem de notificări (design tău)

Diferit față de Ex01-Ex07 și P01-P10: **nu primești cod scheleton, nu primești teste predefinite**. Doar specificația.

## Cerință

Construiește un mini-sistem de notificări care satisface toate criteriile de Definition of Done de mai jos. Decizia de arhitectură (ce adnotări folosești, cum desparți clasele, cum testezi) e a ta.

## Definition of Done

### 1. Trei canale de notificare
- `EmailNotifier`, `SmsNotifier`, `SlackNotifier` — fiecare implementare distinctă a unei interfețe `NotificationChannel`.
- Fiecare canal expune o metodă `send(message)` care întoarce un string în formatul:
  - `"EMAIL: <message>"` pentru email
  - `"SMS: <message>"` pentru SMS
  - `"SLACK: <message>"` pentru Slack

### 2. Canal default ales din config
- În `application.yaml`: cheia `app.notifications.default-channel` cu valoarea `email`, `sms` sau `slack`.
- Un serviciu central `NotificationService.notify(message)` trimite mesajul **prin canalul indicat de yaml**.
- Dacă schimbi yaml-ul de la `email` la `sms`, comportamentul `notify(...)` se schimbă fără rescrierea codului.

### 3. Filtru de spam
- O componentă `SpamFilter` cu un blacklist intern populat **la pornire** (folosește `@PostConstruct`).
- Blacklist-ul conține cel puțin: `"lottery"`, `"winner"`, `"prize"`.
- Mesajele care conțin oricare cuvânt din blacklist (case-insensitive) sunt **respinse**: `NotificationService.notify(...)` întoarce `"BLOCKED: spam detected"` și **nu** trimite mesajul pe canal.

### 4. Audit opțional pe profil
- O componentă `AuditLog` activă **doar** pe profilul `audit`.
- Când e activă, fiecare notificare trimisă (NU cele blocate) e înregistrată — `AuditLog.entries()` întoarce lista mesajelor trimise.
- Când profilul `audit` nu e activ, `AuditLog` nu există în context.

### 5. 4+ teste AAA scrise de tine
- Cel puțin un test pentru fiecare:
  - happy path (notify trimite pe canalul default)
  - spam blocat
  - schimbarea canalului prin config (folosește `@TestPropertySource` sau `@SpringBootTest(properties = ...)`)
  - audit pe profilul `audit` (folosește `@ActiveProfiles("audit")`)

## Constrângeri

- Fără field injection (`@Autowired` pe câmp). Doar constructor injection.
- Mesajele tehnice (excepții, log-uri) în engleză.
- Nu folosi adnotări neacoperite în L01 (`@EventListener`, `@Async`, etc.).

## Cum lucrezi

```bash
cd starter
./mvnw test       # zero teste; le scrii tu
```

Implementează clasele în `src/main/java/com/example/notifications/`. Scrie testele în `src/test/java/com/example/notifications/`.

## Soluție de referință

În [`final/`](./final/) e o implementare validă. **Citește-o doar după** ce ai trimis propria soluție. Există mai multe soluții corecte — `final/` e una dintre ele, nu *singura*.

## Hint-uri (când te blochezi)

<details>
<summary>Cum selectez canalul default din yaml?</summary>

Două abordări curate:

**A.** Injectează `List<NotificationChannel>` (Spring îți dă toate impls); în constructorul `NotificationService` filtrezi după un identificator pe care fiecare canal îl expune (ex. `getName()`).

**B.** Injectează `Map<String, NotificationChannel>` (Spring îți dă un map cu cheile = numele bean-urilor). Folosești `@Component("email")` etc. ca să controlezi cheia. În `NotificationService` citești `@Value("${app.notifications.default-channel}")` și faci lookup în map.

Varianta B e mai scurtă; A e mai explicită.
</details>

<details>
<summary>Cum verific că AuditLog nu e în context fără profil?</summary>

Folosește `ApplicationContext.getBeansOfType(AuditLog.class)` și verifică `.isEmpty()`. Vezi întrebarea 24 din [EXERCITII-TEORIE.md](../EXERCITII-TEORIE.md).
</details>
