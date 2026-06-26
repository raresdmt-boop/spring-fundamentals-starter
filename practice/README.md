# practice — exercițiile tale

27 de exerciții, în 3 niveluri de dificultate crescătoare. Toate testele sunt **RED** la început; le faci **GREEN** adăugând adnotările/codul cerut în clasele din `src/main/`. **Nu modifici testele** — ele sunt contractul.

```bash
./mvnw -pl practice test                            # toate (din rădăcina proiectului)
./mvnw -pl practice test -Dtest=Ex01*               # un singur exercițiu
./mvnw -pl practice test -Dtest=P05RequestCounterTest
```

## Nivel 1 — `ex01-ex07` (ghidate)

Fiecare clasă din `src/main/.../exNN/` are un `// TODO` care-ți spune **exact** ce adnotare să adaugi. Citește TODO-ul → adaugă adnotarea → rulează testul.

| # | Temă | Test |
|---|---|---|
| Ex01 | `@Component` | `Ex01GreetingServiceTest` |
| Ex02 | `@Service` / `@Repository` | `Ex02ServiceRepositoryTest` |
| Ex03 | `@Configuration` + `@Bean` (clasă JDK `Clock`) | `Ex03ClockBeanTest` |
| Ex04 | `@Qualifier` (2 implementări) | `Ex04QualifierTest` |
| Ex05 | `@Value` din `application.yaml` | `Ex05ValueTest` |
| Ex06 | `@Primary` | `Ex06PrimaryTest` |
| Ex07 | `@PostConstruct` | `Ex07PostConstructTest` |

## Nivel 2 — `practica/p01-p10` (doar cerința)

`// Cerință:` într-o frază, fără pas-cu-pas. Tu decizi ce adnotări folosești și unde.

| # | Subiect | Concepte |
|---|---|---|
| P01 | `WeatherService` cu unitate din yaml | `@Service` + `@Value` cu default |
| P02 | `Welcomer` cu `Translator` default | interfață + `@Component` + `@Primary` |
| P03 | `DateTimeFormatter` cu pattern din yaml | `@Configuration` + `@Bean` + `@Value` |
| P04 | `EmailSanitizer` cu blacklist la pornire | `@Component` + `@PostConstruct` |
| P05 | `RequestCounter` — instanță nouă la fiecare lookup | `@Scope("prototype")` |
| P06 | `OrderProcessor` combină `Clock` (Ex03) + `WeatherService` (P01) | constructor injection cross-package |
| P07 | `AuditTrail` activ doar pe profilul `audit` | `@Profile` + `@ActiveProfiles` |
| P08 | `InventoryService` injectează un `List<String>` publicat | `@Bean` colecție + `@Qualifier` |
| P09 | `UserRegistrationService` rulează *toți* validatorii | injecție `List<T>` |
| P10 | `Stopwatch` setează `startedAt` la pornire | `@PostConstruct` în state |

## Nivel 3 — `provocari/c01-c10` (fără hint)

Nicio adnotare, niciun `// TODO`, niciun import pre-pus în cod. Cerința **funcțională** (ce comportament, nu cum) e în [`provocari/README.md`](./src/main/java/com/example/fundamentals/provocari/README.md). Testul îți spune ce trebuie să iasă — **tu alegi singur** mecanismul Spring.

> Aici e scopul: după ce ai văzut adnotările la nivelele 1-2, le aplici fără să ți se mai spună care.
