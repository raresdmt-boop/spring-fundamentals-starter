package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Clock;

@Component
public class DemoRunner implements CommandLineRunner {

    private final GreetingService greeting;
    private final CacheWarmer cacheWarmer;
    private final Clock clock;
    private final Notifier notifier;

    public DemoRunner(GreetingService greeting,
                      CacheWarmer cacheWarmer,
                      Clock clock,
                      Notifier notifier) {
        this.greeting = greeting;
        this.cacheWarmer = cacheWarmer;
        this.clock = clock;
        this.notifier = notifier;
    }

    @Override
    public void run(String... args) {
        line();
        title("SPRING CORE FUNDAMENTALS — DEMO");
        line();
        System.out.println();
        System.out.println("Containerul a terminat de pornit. Acum chemăm bean-urile injectate:");
        System.out.println();

        section("1) @Service + @Value");
        System.out.println("   greeting.greet(\"Ana\") = " + greeting.greet("Ana"));
        System.out.println("   → valoarea \"Hello from yaml\" a fost citită din application.yaml prin @Value.");

        section("2) @Configuration + @Bean (Clock din JDK)");
        System.out.println("   clock.getZone() = " + clock.getZone());
        System.out.println("   → Clock e clasă JDK; nu putem pune @Component pe ea. ClockConfig o publică prin @Bean.");

        section("3) @Primary — alegere implicită între 2 implementări");
        System.out.println("   notifier.send(\"disk full\") = " + notifier.send("disk full"));
        System.out.println("   → Spring a primit 2 bean-uri Notifier (Email + SMS). EmailNotifier are @Primary, deci a câștigat.");

        section("4) @PostConstruct — inițializare după DI");
        System.out.println("   cacheWarmer.all() = " + cacheWarmer.all());
        System.out.println("   → cache-ul a fost populat de metoda @PostConstruct, înainte ca DemoRunner să-l folosească.");

        System.out.println();
        line();
        title("DEMO COMPLETE");
        line();
    }

    private void line() {
        System.out.println("====================================================");
    }

    private void title(String t) {
        System.out.println("  " + t);
    }

    private void section(String name) {
        System.out.println();
        System.out.println("── " + name + " ──");
    }
}
