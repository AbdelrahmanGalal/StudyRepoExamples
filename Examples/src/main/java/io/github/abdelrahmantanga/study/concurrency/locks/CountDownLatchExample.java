package io.github.abdelrahmantanga.study.concurrency.locks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class CountDownLatchExample {

    static void main() {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable startupTask = () -> {
            System.out.println("Starting task with Thread " + Thread.currentThread());
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10001));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finished For Thread " + Thread.currentThread());
            latch.countDown();
        };

        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(startupTask);
        pool.submit(startupTask);
        pool.submit(startupTask);

        System.out.println("Waiting For Latch to finish");
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Startup finished successfully");
        pool.shutdownNow();

    }
}
