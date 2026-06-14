package io.github.abdelrahmantanga.study.concurrency.locks;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private static final ReentrantLock lock = new ReentrantLock(true); // true is for FIFO
    static void main() throws ExecutionException, InterruptedException {
        Callable<Long> task = () -> {
            syncedTask();
            return 0l;
        };
        List<Callable<Long>> tasks = List.of(task, task, task, task, task);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.invokeAny(tasks);

        pool.shutdown();
    }

    private static void syncedTask () {
        try {
            boolean locked = lock.tryLock(3, TimeUnit.SECONDS);
            if (locked) {
                System.out.println("Current Thread : " + Thread.currentThread());
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10001));
            } else {
                System.out.println("Lock not released");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
