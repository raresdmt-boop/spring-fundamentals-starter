# Spring Boot Fundamentals (Lecția 01)

Dependency Injection, ApplicationContext, stereotypes, `@Configuration` + `@Bean`, `@Qualifier`, `@Primary`, `@Value`, `@PostConstruct`, `@Scope`, `@Profile`.

Fără web, fără DB — doar containerul Spring și injecția de dependențe. Proiect Maven **multi-module**; rulezi fiecare modul cu `-pl` din rădăcină.

## Cerințe

```bash
java -version    # 21 (folosește ./mvnw — nu-ți trebuie Maven instalat)
```

## Structură

| modul | rol | teste |
|---|---|---|
| [`teorie/`](./teorie/) | de citit înainte: `THEORY.md`, `GRESELI-COMUNE.md`, `EXERCITII-TEORIE.md` | — |
| [`exercitii-rezolvate/`](./exercitii-rezolvate/) | demo runnable: vezi Spring lucrând pas-cu-pas + exemple rezolvate | ✅ verzi |
| [`practice/`](./practice/) | 27 exerciții de făcut tu (ex01-07 ghidate → practica → provocari fără hint) | 🔴 până le rezolvi |
| [`challenge/starter/`](./challenge/starter/) | capstone: sistem de notificări, schelet + teste de acceptanță | 🔴 până îl rezolvi |

## Ordinea recomandată

```bash
# 1. citește teoria
open teorie/THEORY.md

# 2. vezi conceptele rulând concret în consolă
./mvnw -pl exercitii-rezolvate spring-boot:run

# 3. fă exercițiile (detalii în practice/README.md)
./mvnw -pl practice test

# 4. atacă challenge-ul (detalii în challenge/README.md)
./mvnw -pl challenge/starter test
```

## Comenzi

```bash
./mvnw -pl practice test -Dtest=Ex01GreetingServiceTest   # un singur exercițiu
./mvnw -pl exercitii-rezolvate test                       # toate testele unui modul
./mvnw test                                               # tot (practice+challenge RED până le rezolvi — normal)
```

> `RED` la `practice` și `challenge` e starea de pornire — le faci `GREEN` rezolvând exercițiile. Nu modifici testele.

## Concepte cheie

- **ApplicationContext** — registrul de bean-uri construit de Spring la pornire.
- **Bean** — orice obiect gestionat de Spring (creat, wire-uit, distribuit de container).
- **Component scan** — Spring scanează pachetul `@SpringBootApplication` și sub-pachetele, descoperind clasele `@Component` (sau specializări).
- **Constructor injection** — preferat: imutabilitate, dependențe explicite, testabil fără Spring.
- **`@Configuration` + `@Bean`** — sursă explicită de bean-uri pentru clase pe care nu le poți adnota (JDK, third-party).
- **`@Qualifier` / `@Primary`** — selecție de bean când există mai multe de același tip (`@Qualifier` cere explicit la consumator; `@Primary` declară un default global).
- **`@Value`** — citire de valori scalare din `application.yaml`.

## Definition of Done

- `./mvnw -pl practice test` → toate cele 39 de teste GREEN (ex01-07 + practica + provocari).
- `./mvnw -pl challenge/starter test` → cele 6 teste GREEN.
- Ai parcurs întrebările din [`teorie/EXERCITII-TEORIE.md`](./teorie/EXERCITII-TEORIE.md).
- Poți explica:
  - de ce `Clock` are nevoie de `@Bean` și nu de `@Component`;
  - ce eroare aruncă Spring dacă scoți `@Qualifier` când există 2 implementări;
  - diferența dintre `@Qualifier` și `@Primary`;
  - de ce constructor injection e preferat în locul `@Autowired` pe câmp;
  - când rulează `@PostConstruct` (după DI, înainte ca bean-ul să fie folosit).
