# Demo runnable — Spring Core în consolă

O aplicație Spring Boot care **rulează** (nu doar testează) și imprimă fiecare pas al construirii contextului în consolă. Util ca să vezi *în timp real* secvența: instanțiere → DI → `@PostConstruct` → folosire.

## Rulare

```bash
./mvnw spring-boot:run
```

Aplicația pornește, afișează ce face, apoi se închide imediat (după ce `CommandLineRunner.run()` se întoarce — nu e server web).

## Ce vezi în output

```
[@Component] CacheWarmer instantiated (cache e gol)
[@PostConstruct] CacheWarmer.warmUp() a rulat → cache = [alpha, beta, gamma]
[@Service] GreetingService instantiated — primit greeting='Hello from yaml' via @Value
[@Bean] ClockConfig.clock() called — published Clock(zone=Europe/Bucharest)
[@Component @Primary] EmailNotifier instantiated
[@Component] SmsNotifier instantiated (NU e @Primary)
====================================================
  SPRING CORE FUNDAMENTALS — DEMO
====================================================
...
```

**Observă ordinea:**
1. Spring instanțiază **fiecare bean** (constructor logs).
2. Spring rulează **`@PostConstruct`** pe bean-urile care îl declară — observă că vine *după* constructor.
3. Toate bean-urile sunt gata. Spring apelează `DemoRunner.run(...)` care le folosește.

## Ce concepte combină

| Concept din L01 | Loc în cod |
|---|---|
| `@SpringBootApplication` | `DemoApplication` |
| `@Service` + `@Value` din yaml | `GreetingService` |
| `@Configuration` + `@Bean` cu clasă JDK | `ClockConfig` (Clock) |
| `@Component` + `@Primary` la dezambiguare | `EmailNotifier`, `SmsNotifier` |
| `@PostConstruct` ca lifecycle hook | `CacheWarmer` |
| Constructor injection cu 4 dependențe | `DemoRunner` |
| `CommandLineRunner` ca punct de intrare | `DemoRunner` |

## De ce util

Lucrând cu teste (`@SpringBootTest`), totul e abstract — vezi `assertEquals` trecând, dar nu *vezi* Spring lucrând. Demo-ul face partea ascunsă vizibilă.

## Tweaks

- Schimbă `app.greeting` în `application.yaml` → vezi că output-ul se schimbă fără să recompilezi cod.
- Comentează `@Primary` în `EmailNotifier` → vezi că Spring eșuează la pornire cu `NoUniqueBeanDefinitionException` (același bug ca D02 din `debug/`).
- Comentează `@PostConstruct` în `CacheWarmer` → cache-ul rămâne gol, demo-ul afișează `[]`.
