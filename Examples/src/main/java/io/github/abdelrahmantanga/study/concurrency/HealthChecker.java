package io.github.abdelrahmantanga.study.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class HealthChecker {

    private static final String[] services = {"Redis", "Postgres", "MongoDB", "Kafka", "AWS"};

    static void main() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(5);

        List<Callable<Boolean>> tasks = new ArrayList<>();
        ConcurrentHashMap<String, Boolean> statuses = new ConcurrentHashMap<>();
        for (String service : services) {
            tasks.add(() -> {
                System.out.printf("[%s] Initializing...%n", service);
                int delay = ThreadLocalRandom.current().nextInt(100, 501);
                Thread.sleep(delay);
                statuses.put(service, true);
                System.out.printf("[%s] READY in %dms%n", service, delay);
                latch.countDown();
                return new Random().nextBoolean();
            });
        }

        List<Future<Boolean>> futures = pool.invokeAll(tasks);

        latch.await();
        System.out.println("Services started successfully");
    }
}
