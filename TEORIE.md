# Teorie utilă pentru starter

Tot ce ai nevoie ca să faci `mvn test` GREEN în `ex01-ex07` + `practica/p01-p10`. Citește o dată, întoarce-te când te blochezi.

## Ce face Spring (pe scurt)

Spring e un container de obiecte. Tu marchezi clasele cu adnotări (`@Component`, `@Service`, etc.), Spring le instanțiază la pornire, le ține într-un registru numit **ApplicationContext** și le livrează acolo unde sunt cerute prin **Dependency Injection (DI)**.

`@SpringBootApplication` (deja pus pe `FundamentalsApplication.java`) pornește:
- **component scan** — caută adnotări în pachetul `com.example.fundamentals` și sub-pachete
- **auto-configurare** — încarcă `application.yaml`
- — clasa principală e *configurația rădăcină*

> Clasele din afara pachetului `com.example.fundamentals` nu sunt descoperite. Toate adnotările tale trebuie să stea sub el.

## Adnotări pentru bean-uri (Ex01, Ex02)

Toate trei produc *același efect tehnic*: clasa devine bean. Diferă doar prin **intenție**.

| adnotare | când o pui |
|---|---|
| `@Component` | clasă generică, fără rol specific |
| `@Service` | logică de business |
| `@Repository` | acces la date (DB, fișiere, API extern) |

```java
@Service
public class GreetingService {
    public String greet() { return "Hello"; }
}
```

→ **Ex01** vrea `@Component` pe `GreetingService`.
→ **Ex02** vrea `@Service` pe `Calculator` și `@Repository` pe `BookRepository`.

## `@Configuration` + `@Bean` (Ex03, P03, P08)

Când clasa **nu e a ta** (e din JDK sau dintr-o librărie), nu poți pune `@Component` pe ea. Soluția: o publici manual ca bean dintr-o clasă `@Configuration`:

```java
@Configuration
public class ClockConfig {

    @Bean
    public Clock clock() {
        return Clock.system(ZoneId.of("Europe/Bucharest"));
    }
}
```

- Numele bean-ului = numele metodei (`clock`)
- Spring apelează metoda **o singură dată** la pornire și păstrează rezultatul în context
- Metoda poate primi *alți* bean-uri ca parametri — Spring îi injectează

→ **Ex03** publică un `Clock`.
→ **P03** publică un `DateTimeFormatter` cu pattern din yaml.
→ **P08** publică o `List<String>` ca bean.

## Dependency Injection — constructor (toate exercițiile)

**Preferă constructor injection.** Câmpurile sunt `final`, dependențele sunt vizibile în semnătură, clasa e ușor de testat și fără Spring.

```java
@Service
public class Alerts {
    private final NotificationSender sender;

    public Alerts(NotificationSender sender) {
        this.sender = sender;
    }
}
```

- Dacă există un **singur constructor public**, `@Autowired` e *implicit* — nu îl scrii
- Nu folosi `@Autowired` pe câmpuri private (anti-pattern)

## Două bean-uri de același tip (Ex04, Ex06, P02)

Când există 2+ implementări ale aceluiași tip, Spring nu știe pe care să le aleagă → `NoUniqueBeanDefinitionException` la pornire.

### `@Qualifier` — alegi explicit la consumator

```java
@Component("email") class EmailSender implements NotificationSender { ... }
@Component("sms")   class SmsSender   implements NotificationSender { ... }

@Component
class Alerts {
    Alerts(@Qualifier("email") NotificationSender sender) { ... }
}
```

→ **Ex04**: pune `@Qualifier("email")` pe parametrul din `Alerts`.

### `@Primary` — declari un default

```java
@Component @Primary class StripeGateway implements PaymentGateway { ... }
@Component          class PaypalGateway implements PaymentGateway { ... }

@Component
class Checkout {
    Checkout(PaymentGateway gateway) { ... }  // primește Stripe (e @Primary)
}
```

→ **Ex06**: marchează `StripeGateway` cu `@Primary`; `Checkout` injectează `PaymentGateway` **fără** `@Qualifier`.
→ **P02**: alegi un `Translator` default cu `@Primary`.

**Reține:** dacă există și `@Primary` și `@Qualifier`, `@Qualifier` câștigă.

## `@Value` — citire din `application.yaml` (Ex05, P01, P03)

```java
@Component
class AppProperties {
    private final String greeting;

    AppProperties(@Value("${app.greeting}") String greeting) {
        this.greeting = greeting;
    }
}
```

`application.yaml`:
```yaml
app:
  greeting: "Hello"
```

- Sintaxă: `${cheie}` citește din `application.yaml`
- Default dacă lipsește: `@Value("${app.unit:Celsius}")` — folosește `Celsius` dacă `app.unit` nu există
- Spring face conversia automat la `int`, `boolean`, `long`, etc.

→ **Ex05**: citește `app.greeting` în `AppProperties`.
→ **P01**: citește unitatea cu default `Celsius` în `WeatherService`.
→ **P03**: citește pattern-ul în metoda `@Bean` pentru `DateTimeFormatter`.

## `@PostConstruct` — rulează după DI (Ex07, P04, P10)

Metoda marcată cu `@PostConstruct` se execută **după** ce Spring a făcut injecția, **înainte** ca bean-ul să fie folosit.

```java
@Component
class CacheWarmer {
    private final List<String> cache = new ArrayList<>();

    @PostConstruct
    void init() {
        cache.add("warm-up-data");
    }
}
```

Util pentru: pre-încărcare cache, validare config la pornire, conexiuni externe.

→ **Ex07**: populează cache-ul din `CacheWarmer` cu `@PostConstruct`.
→ **P04**: populezi blacklist-ul din `EmailSanitizer`.
→ **P10**: setezi `startedAt` în `Stopwatch`.

## `@Scope("prototype")` (P05)

Default-ul Spring e **singleton** — o singură instanță pe tot containerul. Cu `@Scope("prototype")`, primești **instanță nouă** la fiecare cerere.

```java
@Component
@Scope("prototype")
class RequestCounter { ... }
```

**Atenție:** dacă injectezi un `prototype` într-un `singleton` o singură dată, primești tot o singură instanță. În test, cere bean-ul de mai multe ori prin `ApplicationContext.getBean(...)`.

→ **P05**: marchează `RequestCounter` cu `@Scope("prototype")`.

## `@Profile` — bean activ doar pe un environment (P07)

```java
@Component
@Profile("audit")
class AuditTrail { ... }
```

Bean-ul există în context **doar** dacă profilul `audit` e activ. În test:

```java
@SpringBootTest
@ActiveProfiles("audit")
class P07AuditTrailTest { ... }
```

→ **P07**: `AuditTrail` activ doar pe profilul `audit`.

## Injecție `List<T>` — toate implementările (P09)

Dacă ceri `List<UserValidator>` într-un constructor, Spring îți dă **toate** bean-urile care implementează `UserValidator` din context — automat.

```java
@Service
class UserRegistrationService {
    private final List<UserValidator> validators;

    UserRegistrationService(List<UserValidator> validators) {
        this.validators = validators;
    }
}
```

→ **P09**: `UserRegistrationService` validează cu *toate* `UserValidator`-ele găsite în context.

## Bean cu colecție (P08)

Poți publica un `List<String>` ca bean dintr-o metodă `@Bean`. Consumatorul îl cere cu `@Qualifier` dacă există mai multe `List`-uri în context.

```java
@Configuration
class ProductCatalogConfig {

    @Bean
    public List<String> productCatalog() {
        return List.of("laptop", "phone", "tablet");
    }
}

@Service
class InventoryService {
    InventoryService(@Qualifier("productCatalog") List<String> catalog) { ... }
}
```

→ **P08**: publici catalogul, consumi cu `@Qualifier`.

## Cum rulezi

```bash
./mvnw test                       # toate (RED la început)
./mvnw test -Dtest=Ex01*          # un singur exercițiu ghidat
./mvnw test -Dtest=P05*           # un singur exercițiu de practică
./mvnw test -Dtest=Ex*            # toate ghidate
./mvnw test -Dtest=P*             # toate de practică
```

## Cheat sheet — adnotările de care ai nevoie

| adnotare | unde o pui | exercițiu |
|---|---|---|
| `@Component` | clasă generică | Ex01 |
| `@Service` | clasă business logic | Ex02, P01, P06, P09 |
| `@Repository` | clasă acces date | Ex02 |
| `@Configuration` | clasă cu metode `@Bean` | Ex03, P03, P08 |
| `@Bean` | metodă în `@Configuration` | Ex03, P03, P08 |
| `@Qualifier("nume")` | parametru constructor | Ex04, P08 |
| `@Primary` | clasă (sau metodă `@Bean`) | Ex06, P02 |
| `@Value("${cheie}")` | parametru constructor | Ex05, P01, P03 |
| `@Value("${cheie:default}")` | cu fallback | P01 |
| `@PostConstruct` | metodă fără args | Ex07, P04, P10 |
| `@Scope("prototype")` | clasă | P05 |
| `@Profile("nume")` | clasă | P07 |

## Greșeli frecvente

1. **Uiți `@Component` (sau echivalent)** — clasa nu devine bean → testul vede `null` sau `NoSuchBeanDefinitionException` la pornire.
2. **`@Bean` în loc de `@Component`** pentru clase pe care le deții — funcționează, dar nu e idiomatic. Folosește `@Component` când *poți*; `@Bean` doar pentru clase third-party.
3. **`@Autowired` pe câmp** — anti-pattern. Folosește constructor.
4. **Două bean-uri fără `@Qualifier` / `@Primary`** — `NoUniqueBeanDefinitionException` la pornire. Citește stack trace-ul.
5. **`@Value("${cheie}")` fără valoare în yaml și fără default** — `IllegalArgumentException: Could not resolve placeholder`.
6. **`@PostConstruct` cu parametri** — nu e permis. Metoda trebuie să fie `void` și fără argumente.
7. **Clasă în afara pachetului `com.example.fundamentals`** — component scan-ul n-o vede.

## Definition of Done

- [ ] `./mvnw test -Dtest=Ex*` — 7/7 GREEN
- [ ] `./mvnw test -Dtest=P*` — 10/10 GREEN
- [ ] Poți explica:
  - de ce `Clock` are nevoie de `@Bean` și nu de `@Component`
  - ce eroare aruncă Spring fără `@Qualifier` în Ex04
  - diferența dintre `@Qualifier` și `@Primary`
  - când rulează `@PostConstruct` (înainte/după DI?)
  - de ce `@Scope("prototype")` într-un singleton necesită `getBean()` repetat ca să vezi instanțe noi
