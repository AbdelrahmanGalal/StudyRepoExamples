package io.github.abdelrahmantanga.study.concurrency.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newScheduledThreadPool;
import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;

public class ScheduledExecutorServiceExample {

    static void main() throws InterruptedException {
        System.out.println("First example is Scheduled Fixed Rate");
        System.out.println("-------------------------------------------------------\n");
        fixedRate();
        System.out.println("\n\n");

        System.out.println("Second example is Scheduled Fixed Delay");
        System.out.println("-------------------------------------------------------\n");
        fixedDelay();
        System.out.println("\n\n");
    }

    private static void fixedDelay() {
        // Fixed DELAY: period measured from END of previous execution
        // (safer for tasks with variable duration)

        try (ScheduledExecutorService scheduler = newScheduledThreadPool(2)) {
            ScheduledFuture<?> heartbeat = scheduler.scheduleWithFixedDelay(
                    () -> System.out.println("Poll"),
                    0, 500, TimeUnit.MILLISECONDS
            );

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fixedRate() {
        // Fixed RATE: next fires at start + period
        // (if task takes longer than period, next fires immediately after it finishes)
        try (ScheduledExecutorService scheduler = newSingleThreadScheduledExecutor()) {
            ScheduledFuture<?> heartbeat = scheduler.scheduleAtFixedRate(() -> System.out.println("BA-DUM BA-DUM"),
                    0,   // initial delay
                    1,   // period
                    TimeUnit.SECONDS);
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
