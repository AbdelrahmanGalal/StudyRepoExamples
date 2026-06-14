package io.github.abdelrahmantanga.study.concurrency;

import java.util.*;
import java.util.concurrent.*;

public class ServiceStartupGate {

    enum Status { READY, FAILED }

    public static void main(String[] args) throws InterruptedException {
        String[] services = { "Database", "RedisCache", "MessageBroker" };

        CountDownLatch latch                        = new CountDownLatch(services.length);
        ConcurrentHashMap<String, Status> statuses  = new ConcurrentHashMap<>();
        ExecutorService pool                         = Executors.newFixedThreadPool(services.length);

        long start = System.currentTimeMillis();

        for (String service : services) {
            pool.submit(() -> {
                try {
                    System.out.printf("[%s] Initializing...%n", service);
                    long delay = 500 + (long)(Math.random() * 2000); // 0.5–2.5s
                    Thread.sleep(delay);
                    statuses.put(service, Status.READY);
                    System.out.printf("[%s] READY in %dms%n", service, delay);
                } catch (InterruptedException e) {
                    statuses.put(service, Status.FAILED);
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown(); // always countdown — even on failure
                }
            });
        }

        // Gate: block until all services report in, or timeout after 10s
        boolean allReported = latch.await(10, TimeUnit.SECONDS);
        long elapsed = System.currentTimeMillis() - start;
        pool.shutdown();

        if (!allReported) {
            System.out.println("STARTUP TIMEOUT after " + elapsed + "ms");
            return;
        }
        if (statuses.containsValue(Status.FAILED)) {
            System.out.println("STARTUP FAILED — one or more services did not initialize");
        } else {
            System.out.printf("ALL SERVICES READY in %dms — application starting%n", elapsed);
        }
    }
}
