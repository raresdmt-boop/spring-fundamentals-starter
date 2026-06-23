package com.example.fundamentals.finala.f03;

// Cerință (vezi finala/README.md → F03):
// MetricsBuffer e un bean Spring care ține eșantioane numerice.
//   - isReady() devine true după ce contextul a pornit (inițializare la pornire).
//   - record(v) adaugă un eșantion, dar NU peste o capacitate maximă citită din
//     configurare (app.metrics.capacity, default 3). count() = câte sunt ținute.
//   - la oprirea contextului bean-ul se "golește": isFlushed() devine true și
//     count() devine 0.

public class MetricsBuffer {

    public void record(int value) {
    }

    public int count() {
        return 0;
    }

    public boolean isReady() {
        return false;
    }

    public boolean isFlushed() {
        return false;
    }
}
