# Lecția 01 — Spring Core Fundamentals

Dependency Injection, ApplicationContext, stereotypes, `@Configuration` + `@Bean`, `@Qualifier`, `@Primary`, `@Value`, `@PostConstruct`.

Fără web, fără DB — doar containerul Spring și injecția de dependențe.

> **Teorie**: citește [THEORY.md](./THEORY.md) înainte de exerciții. Acoperă toate adnotările de bază (inclusiv `@Scope`, `@Lazy`, `@Profile`, `@PreDestroy`) cu mini-exemple.
>
> **Auto-verificare**: [EXERCITII-TEORIE.md](./EXERCITII-TEORIE.md) — 25 întrebări cu răspunsuri.
>
> **Anti-pattern catalog**: [GRESELI-COMUNE.md](./GRESELI-COMUNE.md) — 15 greșeli comune cu fix-uri, util la code review.

## Structură

| folder | rol |
|---|---|
| [`starter/`](./starter/) | Ghidate + practica (cu TODO/cerințe) — toate teste RED |
| [`final/`](./final/) | Implementare completă pentru starter — toate teste GREEN |
| [`notes/`](./notes/) | Copie după `final/` pentru notele instructorului |
| [`debug/`](./debug/) | 7 mini-bug-uri Spring de identificat și fixat (citire de stack trace) |
| [`demo/`](./demo/) | Spring Boot app runnable care afișează în consolă ce face containerul la pornire |
| [`challenge/`](./challenge/) | Sistem de notificări open-ended cu DoD — student își scrie singur testele |

## Cerințe

- Java 21
- Maven 3.9+

```bash
java -version
mvn -version
```

## Cum lucrezi (starter)

```bash
cd starter
mvn test
```

Toate testele sunt **RED** la început. Deschide pe rând `src/main/java/com/example/fundamentals/exNN/`, citește TODO-urile și adaugă adnotările cerute până când testul corespunzător devine **GREEN**.

Rulează doar un exercițiu:

```bash
mvn test -Dtest=Ex01*
mvn test -Dtest=Ex02*
# ...
```

## Cum verifici (final)

```bash
cd final
mvn test
```

Toate cele 5 exerciții trec.

## Exerciții

### Ex01 — `@Component`
Marchează `GreetingService` cu `@Component` ca Spring să-l descopere la *component scan* și să-l publice ca bean în `ApplicationContext`.

**Test:** `Ex01GreetingServiceTest`

### Ex02 — `@Service` și `@Repository`
Diferențiază semantic logică de business (`@Service`) de acces la date (`@Repository`). Toate trei (`@Component`, `@Service`, `@Repository`) produc un bean — dar exprimă intenția.

**Test:** `Ex02ServiceRepositoryTest`

### Ex03 — `@Configuration` + `@Bean`
Publică un `Clock` (clasă JDK) ca bean. `@Component` nu se poate pune pe clase pe care nu le deții — `@Bean` într-o clasă `@Configuration` rezolvă.

**Test:** `Ex03ClockBeanTest`

### Ex04 — `@Qualifier`
Două implementări de `NotificationSender` (Email + SMS). Folosește `@Qualifier("email")` pe parametrul constructorului ca Spring să știe care bean să-l injecteze.

Fără `@Qualifier` Spring aruncă `NoUniqueBeanDefinitionException` la pornire.

**Test:** `Ex04QualifierTest`

### Ex05 — `@Value` + `application.yaml`
Citește `app.greeting` din `application.yaml` într-un bean folosind `@Value("${app.greeting}")` pe parametrul constructorului.

**Test:** `Ex05ValueTest`

### Ex06 — `@Primary`
Două implementări de `PaymentGateway` (Stripe + PayPal). Marchează Stripe cu `@Primary`. Consumatorul (`Checkout`) injectează `PaymentGateway` *fără* `@Qualifier` — Spring alege Stripe pentru că e default.

`@Primary` și `@Qualifier` rezolvă aceeași problemă (ambiguitate când există 2+ bean-uri). Diferența: `@Primary` declară un default global, `@Qualifier` cere explicit la consumator. `@Qualifier` câștigă dacă e prezent.

**Test:** `Ex06PrimaryTest`

### Ex07 — `@PostConstruct`
Adaugă un `CacheWarmer` cu o metodă `@PostConstruct` care populează un cache la pornire. Spring apelează metoda *după* DI, *înainte* ca bean-ul să fie folosit.

Util pentru: pre-încărcare, validare config, conexiuni externe.

**Test:** `Ex07PostConstructTest`

## Practică — fără hint-uri

După ce ai trecut Ex01-Ex07, pachetul `practica/` îți dă 5 exerciții suplimentare cu **doar cerința într-o frază + testul**. Fără TODO-uri pas-cu-pas — tu decizi ce adnotări folosești și unde.

```bash
./mvnw test -Dtest=P*
```

| # | Subiect | Combinație de concepte |
|---|---|---|
| P01 | `WeatherService` întoarce temperatura cu unitate din yaml | `@Service` + `@Value` cu default |
| P02 | `Welcomer` folosește un `Translator` default între Engleză și Franceză | interfață + `@Component` + `@Primary` |
| P03 | Publică un `DateTimeFormatter` cu pattern din yaml | `@Configuration` + `@Bean` + `@Value` în parametru |
| P04 | `EmailSanitizer` cu blacklist populat la pornire | `@Component` + `@PostConstruct` |
| P05 | `RequestCounter` — instanță nouă la fiecare cerere (stretch) | `@Component` + `@Scope("prototype")` |
| P06 | `OrderProcessor` combină `Clock` (din Ex03) și `WeatherService` (din P01) | constructor injection multi-deps + cross-package |
| P07 | `AuditTrail` activ doar pe profilul "audit" | `@Profile` + `@ActiveProfiles` în test |
| P08 | `ProductCatalog` publică `List<String>` ca bean; `InventoryService` îl injectează | `@Bean` cu colecție + `@Qualifier` la consumator |
| P09 | `UserRegistrationService` validează cu *toate* `UserValidator`-ele din context | injecție `List<T>` (toate impls automat) |
| P10 | `Stopwatch` înregistrează `startedAt` automat la pornirea bean-ului | `@PostConstruct` aplicat în state |

## Debug — citește cod Spring spart

[`debug/`](./debug/) are 7 mini-aplicații Spring Boot care **compilează dar nu pornesc**. Citește stack trace-ul, identifică bug-ul, propune fix. Vezi [debug/README.md](./debug/README.md) și [debug/SOLUTIONS.md](./debug/SOLUTIONS.md).

```bash
cd debug
./mvnw test -Dtest=D01Test    # un singur bug
```

Bug-uri acoperite: `NoSuchBean`, `NoUniqueBean`, `@Value` typo, dependency circulară, pachet nescanat, 2 constructori publici, `@Configuration` lipsă.

## Demo — vezi Spring rulând în consolă

[`demo/`](./demo/) e o app Spring Boot care imprimă **pas cu pas** ce face containerul: instanțiere bean → DI → `@PostConstruct` → folosire. Util ca să faci concret ce vezi în teste.

```bash
cd demo
./mvnw spring-boot:run
```

## Challenge — design tău

[`challenge/`](./challenge/) — sistem de notificări cu 5 cerințe DoD. Fără cod scheleton, fără teste predefinite. Tu decizi arhitectura, tu scrii testele. În `final/` e o soluție de referință (citește-o doar după ce ai trimis a ta).

## Concepte cheie

- **ApplicationContext** — registrul de bean-uri construit de Spring la pornire.
- **Bean** — orice obiect gestionat de Spring (creat, wire-uit, distribuit de container).
- **Component scan** — Spring scanează pachetul root al `@SpringBootApplication` și sub-pachetele, descoperind clasele adnotate cu `@Component` (sau specializări).
- **Constructor injection** — preferat: imutabilitate, dependențe explicite, ușor de testat fără Spring.
- **`@Configuration` + `@Bean`** — sursă explicită de bean-uri pentru clase pe care nu le poți adnota (JDK, librării third-party).
- **`@Qualifier`** — selecție de bean când există mai multe de același tip.
- **`@Value`** — citire de valori scalare din `application.yaml` / `application.properties`.

## Definition of Done

- `./mvnw test` trece în `starter/` pentru toate Ex01-Ex07 (10 teste).
- Bonus: ai rezolvat practica/ P01-P10 (în total 26/26 GREEN cu tot cu Ex01-Ex07).
- Ai parcurs cel puțin întrebările 1-15 din [EXERCITII-TEORIE.md](./EXERCITII-TEORIE.md); 16-25 sunt pentru aprofundare.
- Poți explica:
  - de ce `Clock` are nevoie de `@Bean` și nu de `@Component`
  - ce eroare aruncă Spring dacă scoți `@Qualifier` din `Alerts`
  - diferența dintre `@Qualifier` și `@Primary` (vezi Ex04 vs Ex06)
  - de ce constructor injection e preferat în locul `@Autowired` pe câmp
  - când rulează `@PostConstruct` (înainte/după DI? înainte/după ca bean-ul să fie folosit?)
