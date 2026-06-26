package com.example.fundamentals.ex03;

import java.time.Clock;
import java.time.ZoneId;

// TODO:
//   1. Marchează clasa cu @Configuration ca Spring să citească definițiile de
//      bean-uri din ea la pornire.
//   2. Adaugă o metodă publică `Clock clock()` adnotată cu @Bean care întoarce
//      Clock.system(ZoneId.of("Europe/Bucharest")).
//      → De ce @Bean și nu @Component pe clasa Clock? Pentru că `Clock` e o
//        clasă din JDK — nu putem să o modificăm ca să adăugăm o adnotare.
//        @Bean ne lasă să publicăm orice obiect în container, indiferent de
//        cine deține clasa.
//   3. Numele bean-ului = numele metodei (`clock`). Va fi disponibil pentru
//      @Autowired oriunde declari `Clock`.

public class ClockConfig {
}
