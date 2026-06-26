# Soluții — bug-urile din debug/

Citește **după** ce încerci singur să fixezi.

---

## D01 — `@Component` lipsă pe `GreetingService`

**Eroare:**
```
NoSuchBeanDefinitionException: No qualifying bean of type
'com.example.debug.d01.GreetingService' available
```

**Cauza:** `GreetingClient` cere `GreetingService` în constructor, dar clasa `GreetingService` n-are nicio adnotare stereotype — nu e descoperită la component scan.

**Fix:**
```java
@Component
public class GreetingService { ... }
```

**De reținut:** când vezi `No qualifying bean of type X`, începe cu *clasa X însăși* — în 80% din cazuri îi lipsește `@Component`/`@Service`/`@Repository`.

---

## D02 — 2 implementări `EmailFormatter`, niciun discriminator

**Eroare:**
```
NoUniqueBeanDefinitionException: expected single matching bean
but found 2: htmlFormatter, plainFormatter
```

**Cauza:** `EmailSender` cere `EmailFormatter` în constructor. Spring găsește două bean-uri (`HtmlFormatter`, `PlainFormatter`), nu știe pe care să-l aleagă.

**Fix variantă A** (consumatorul decide explicit):
```java
public EmailSender(@Qualifier("htmlFormatter") EmailFormatter formatter) { ... }
```

**Fix variantă B** (alegi un default global):
```java
@Component @Primary
public class HtmlFormatter implements EmailFormatter { ... }
```

**De reținut:** `NoUniqueBean` = problemă de ambiguitate, nu de absență.

---

## D03 — `@Value` cu cheie greșită

**Eroare:**
```
PlaceholderResolutionException: Could not resolve placeholder 'app.timeoutt'
```

**Cauza:** `TimeoutConfig` cere `${app.timeoutt}` (cu doi `t`), dar yaml-ul are `app.timeout` (cu un `t`).

**Fix:**
```java
public TimeoutConfig(@Value("${app.timeout}") int timeoutSeconds) { ... }
```

**Alternativ — default ca să nu eșuezi la pornire:**
```java
@Value("${app.timeoutt:30}") int timeoutSeconds
```

**De reținut:** Spring eșuează la pornire pentru proprietăți lipsă — bine, nu rău. Mai bine decât să descoperi în prod că funcționează cu null.

---

## D04 — Dependency circulară prin constructor

**Eroare:**
```
BeanCurrentlyInCreationException: Requested bean is currently in creation:
Is there an unresolvable circular reference?
```

**Cauza:** `ServiceA` cere `ServiceB` în constructor, `ServiceB` cere `ServiceA`. Spring nu poate construi pe niciunul fără celălalt.

**Fix (refactor real):** extrage o a treia clasă care cuprinde codul comun, sau combină responsabilitățile celor două.

**Fix tactic (NU folosi în proiecte serioase):** rupi ciclul cu `@Lazy`:
```java
public ServiceA(@Lazy ServiceB serviceB) { ... }
```
`@Lazy` injectează un proxy care nu instanțiază `ServiceB` decât la prima chemare. Funcționează — dar ascunde un design problematic.

**De reținut:** Spring 3.x+ refuză circulari prin constructor by default. E un design smell — nu un bug de framework.

---

## D05 — Clasă în pachet nescanat

**Eroare:**
```
NoSuchBeanDefinitionException: No qualifying bean of type
'com.other.d05outside.LegacyMetricsAdapter' available
```

**Cauza:** `D05Application` are `scanBasePackages = "com.example.debug.d05"`. Dar `LegacyMetricsAdapter` e în `com.other.d05outside` — *în afara* pachetului scanat.

**Fix variantă A** (extinzi scan-ul):
```java
@SpringBootApplication(scanBasePackages = {
    "com.example.debug.d05",
    "com.other.d05outside"
})
```

**Fix variantă B** (muți clasa în pachetul scanat). De obicei mai bun pentru cod propriu; varianta A e justificată pentru librării third-party.

**De reținut:** `@ComponentScan` default scanează doar pachetul clasei principale și sub-pachetele lui. Tot ce e în afară e invizibil.

---

## D06 — 2 constructori publici, niciunul cu `@Autowired`

**Eroare:**
```
BeanInstantiationException: Failed to instantiate [ReportingService]:
No default constructor found
NoSuchMethodException: ReportingService.<init>()
```

**Cauza:** Spring 4.3+ alege constructorul automat **doar dacă există unul singur public**. Cu 2 constructori, Spring nu știe pe care să-l folosească, încearcă constructorul fără argumente (default), și nu-l găsește.

**Fix:**
```java
@Autowired
public ReportingService(LoggerService logger) {
    this.logger = logger;
    this.prefix = "default";
}
```

`@Autowired` pe constructorul dorit spune explicit "ăsta e cel pentru DI". Celălalt rămâne disponibil pentru cod de test (`new ReportingService(logger, "custom")`).

**De reținut:** dacă ai un singur constructor public, nu-i pune `@Autowired` — e redundant. Adaugă-l doar când există ambiguitate.

---

## D07 — `@Configuration` lipsă pe clasa cu `@Bean`-uri

**Eroare:**
```
NoSuchBeanDefinitionException: No qualifying bean of type
'com.example.debug.d07.ApiClient' available
```

**Cauza:** `ApiConfig` are o metodă `@Bean apiClient()` — dar clasa în sine n-are nicio adnotare stereotype. Spring nu o încarcă, deci `@Bean`-urile dinăuntru sunt invizibile.

**Fix:**
```java
@Configuration
public class ApiConfig {
    @Bean
    public ApiClient apiClient() { ... }
}
```

**De reținut:** `@Bean` are nevoie de o "gazdă" descoperită de Spring — `@Configuration` e standardul. (Tehnic și `@Component` funcționează cu `@Bean`, dar pierde proxy-ul care garantează singleton — vezi THEORY.md secțiunea 3.2 și Q13 din EXERCITII-TEORIE.)
