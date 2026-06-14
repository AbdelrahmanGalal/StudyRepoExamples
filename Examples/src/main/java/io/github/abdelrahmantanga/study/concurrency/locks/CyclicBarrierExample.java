package io.github.abdelrahmantanga.study.concurrency.locks;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    static void main() {
        CyclicBarrier barrier = new CyclicBarrier(3);

        Runnable task = () -> {
            System.out.println("Parking Thread For the Barrier For 10 Secs Timeout");
            try {
                barrier.await(10, TimeUnit.SECONDS);
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                System.out.println("Barrier Timeout and return");
                return;
            }
            System.out.println("Barrier opened and execution started " + Thread.currentThread());
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5001));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            pool.submit(task);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pool.shutdownNow();
    }
}
