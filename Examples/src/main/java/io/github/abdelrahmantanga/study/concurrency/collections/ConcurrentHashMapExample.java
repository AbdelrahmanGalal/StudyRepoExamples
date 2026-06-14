package io.github.abdelrahmantanga.study.concurrency.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ConcurrentHashMapExample {

    static void main() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

// Basic ops — same as HashMap
        map.put("a", 1);
        map.get("a");
        map.remove("a");

        int oldVal = 1000;
        int newVal = 2000;
// ATOMIC compound ops — use these instead of get + put
        map.putIfAbsent("key", 42);                           // only if absent
        map.computeIfAbsent("key", k -> expensive());         // compute and store only if absent
        map.computeIfPresent("key", (k, v) -> v + 1);         // update only if present
        map.compute("counter", (k, v) -> v == null ? 1 : v + 1); // atomic increment (upsert)
        map.merge("key", 1, Integer::sum);                    // add 1, or initialize to 1
        map.replace("key", oldVal, newVal);                   // CAS-style conditional replace

// Bulk operations (Java 8+) — weakly consistent, no global lock
        map.forEach(1, (k, v) -> System.out.println(k + "=" + v)); // parallelism threshold = 1
        long total = map.reduceValues(1, v -> (long) v, Long::sum);
    }

    private static Integer expensive() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ThreadLocalRandom.current().nextInt(1000, 100001);
    }
}
