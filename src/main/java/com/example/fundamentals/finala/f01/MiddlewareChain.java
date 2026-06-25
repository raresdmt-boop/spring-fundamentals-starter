package com.example.fundamentals.finala.f01;

import org.springframework.stereotype.Component;

import java.util.List;

// Cerință (vezi finala/README.md → F01):
// MiddlewareChain primește TOATE implementările de Middleware din context și le
// aplică pe payload în ORDINEA cerută: auth, apoi log, apoi zip.
//   process("REQ") -> "REQ[auth][log][zip]"
// size() întoarce câte middleware-uri au fost descoperite, valoare calculată o
// singură dată după ce injecția s-a terminat.
@Component
public class MiddlewareChain {

    private final List<Middleware> middleware;

    public MiddlewareChain(List<Middleware> middleware) {
        this.middleware = middleware;
    }

    public String process(String payload) {
        for(Middleware m : middleware){
            payload = m.handle(payload);
        }
        return payload;
    }

    public int size() {
        return middleware.size();
    }
}
