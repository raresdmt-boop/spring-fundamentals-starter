# Debug — identifică și fixează bug-uri Spring

7 mini-bug-uri pe care le vei întâlni în primele luni la job. Fiecare proiect e o aplicație Spring Boot care **compilează dar nu pornește / nu trece testul**.

## Cum lucrezi

```bash
./mvnw test -Dtest=D01Test    # rulezi un singur bug
./mvnw test                   # toate 7 (toate sunt RED la început)
```

Pașii pentru fiecare bug:

1. Rulează testul. Citește stack trace-ul.
2. Identifică **clasa și linia** unde e bug-ul (caută `🐛` în comentariile sursei pentru hint).
3. Propune un fix. Rulează din nou testul.
4. Verifică în [SOLUTIONS.md](./SOLUTIONS.md) dacă ai prins cauza root.

## Bug-uri

| # | Clasă afectată | Eroarea la pornire | Concept |
|---|---|---|---|
| D01 | `d01.GreetingService` | `NoSuchBeanDefinitionException` | Component scan / `@Component` |
| D02 | `d02.EmailSender` | `NoUniqueBeanDefinitionException` | Dezambiguare cu `@Qualifier` / `@Primary` |
| D03 | `d03.TimeoutConfig` | `Could not resolve placeholder` | `@Value` + `application.yaml` |
| D04 | `d04.ServiceA` / `ServiceB` | `BeanCurrentlyInCreationException` | Dependency circulară |
| D05 | `d05.MetricsCollector` | `NoSuchBeanDefinitionException` | `@ComponentScan` și pachetul scanat |
| D06 | `d06.ReportingService` | `No default constructor found` | Constructor injection cu 2+ constructori publici |
| D07 | `d07.ApiClient` | `NoSuchBeanDefinitionException` | `@Bean` are nevoie de `@Configuration` |

## De ce e izolat fiecare bug

Fiecare exercițiu are propriul `DxxApplication` cu `scanBasePackages = "com.example.debug.dXX"`, deci eroarea dintr-un bug nu cascadează la celelalte teste. Testul `D03` *nu* eșuează din cauza bug-ului din D01 — fiecare e independent.

## Ce înveți

Mai mult decât a *scrie* Spring corect, înveți să **citești** stack trace-uri Spring: care e excepția de top, ce înseamnă fiecare `Caused by`, cum localizezi clasa-problemă în mesaj.
