package io.github.abdelrahmantanga.study.concurrency.locks;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionVariableExample {

    // ONE single lock to protect the shared state (count)
    private static final ReentrantLock lock = new ReentrantLock(true);
    private static final AtomicInteger count = new AtomicInteger(0);
    private static final int MAX_CAPACITY = 3;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService producerPool = Executors.newFixedThreadPool(1);
        ExecutorService consumerPool = Executors.newFixedThreadPool(1);

        // Both conditions MUST be tied to the same single lock
        Condition produceCondition = lock.newCondition();
        Condition consumeCondition = lock.newCondition();

        Callable<Void> produceMessage = () -> {
            lock.lock(); // Acquire the shared lock
            try {
                while (count.get() >= MAX_CAPACITY) {
                    produceCondition.await(); // Releases lock while waiting
                }
                count.incrementAndGet();
                System.out.println("Produced Message. Total: " + count.get());
                consumeCondition.signalAll(); // Works because we hold 'lock'
                Thread.sleep(1000);
            } finally {
                lock.unlock(); // Always release
            }
            return null;
        };

        Callable<Void> consumeMessage = () -> {
            lock.lock(); // Acquire the exact same shared lock
            try {
                while (count.get() == 0) {
                    consumeCondition.await(); // Releases lock while waiting
                }
                count.decrementAndGet();
                System.out.println("Consumed Message. Total: " + count.get());
                produceCondition.signalAll(); // Works because we hold 'lock'
                Thread.sleep(2000);
            } finally {
                lock.unlock(); // Always release
            }
            return null;
        };

        for (int i = 0 ; i < 6; i++) {
            producerPool.submit(produceMessage);
            consumerPool.submit(consumeMessage);
        }

        Thread.sleep(15000);

        consumerPool.shutdown();
        producerPool.shutdown();
    }
}
