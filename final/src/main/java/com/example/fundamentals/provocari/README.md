# Provocări — soluții (referință)

Implementările complete pentru cele 10 provocări fără hinturi. Folosește acest folder DOAR după ce ai încercat tu, ca să compari abordările.

| # | Topic ascuns | Adnotări/mecanism folosit |
|---|---|---|
| c01 | bean simplu | `@Component` |
| c02 | implementare default între multiple | `@Primary` + constructor injection |
| c03 | citire proprietate | `@Value("${app.vat.rate}")` în constructor |
| c04 | instanță fresh per cerere | `@Scope("prototype")` |
| c05 | inițializare la startup | `@PostConstruct` |
| c06 | bean condițional pe profil | `@Profile("ops")` |
| c07 | inject all implementations | `List<Validator>` în constructor |
| c08 | publică bean-uri dintr-o clasă | `@Configuration` + `@Bean` |
| c09 | strategie după cheie | `Map<String, PaymentStrategy>` autoinjectat |
| c10 | lifecycle hooks | `@PostConstruct` + `@PreDestroy` |
