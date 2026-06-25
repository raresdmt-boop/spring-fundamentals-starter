package com.example.fundamentals.finala.f03;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Cerință (vezi finala/README.md → F03):
// MetricsBuffer e un bean Spring care ține eșantioane numerice.
//   - isReady() devine true după ce contextul a pornit (inițializare la pornire).
//   - record(v) adaugă un eșantion, dar NU peste o capacitate maximă citită din
//     configurare (app.metrics.capacity, default 3). count() = câte sunt ținute.
//   - la oprirea contextului bean-ul se "golește": isFlushed() devine true și
//     count() devine 0.
@Component
@Scope("prototype")
public class MetricsBuffer {

    public void record(@Value("${app.metrics.capacity}") String value) {
        if(count()<Integer.parseInt(value)){
        }
    }

    public int count() {

    }

    @PostConstruct
    public boolean isReady() {
        
        return true;
    }

    public boolean isFlushed() {
        return false;
    }
}
