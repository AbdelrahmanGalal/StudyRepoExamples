package io.github.abdelrahmantanga.study.concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    static void main() {
        Semaphore semaphore = new Semaphore(3);

        Runnable task = () -> {
            System.out.println("Acquiring permit");
            try {
                semaphore.acquire();
                System.out.println("Permit Aquired " + Thread.currentThread());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
                System.out.println("Permit Released " + Thread.currentThread());
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 8; i++) {
            pool.submit(task);
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pool.shutdown();
    }
}
