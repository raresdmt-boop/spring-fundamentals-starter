package com.example.fundamentals.finala.f01;

import java.util.List;

// Cerință (vezi finala/README.md → F01):
// MiddlewareChain primește TOATE implementările de Middleware din context și le
// aplică pe payload în ORDINEA cerută: auth, apoi log, apoi zip.
//   process("REQ") -> "REQ[auth][log][zip]"
// size() întoarce câte middleware-uri au fost descoperite, valoare calculată o
// singură dată după ce injecția s-a terminat.

public class MiddlewareChain {

    public String process(String payload) {
        return null;
    }

    public int size() {
        return 0;
    }
}
