package io.github.abdelrahmantanga.study.concurrency.executors;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {

    static void main() {
        System.out.println("First example is basic Fixed size pool with interruption");
        System.out.println("-------------------------------------------------------\n\n");
        basicExecutionService();

        System.out.println("\n\n");
        System.out.println("Second example is using Future to get Async result");
        System.out.println("------------------------------------------------------- \n\n");
        waitFutureResult();

        System.out.println("\n\n");
        System.out.println("Second example is using Future to get Async result");
        System.out.println("------------------------------------------------------- \n\n");
        getFirstResultFromMultipleThreads();
    }

    private static void getFirstResultFromMultipleThreads() {
        ExecutorService pool = Executors.newCachedThreadPool();

        Callable<String> callable = () -> {
            System.out.println("Running start " + Thread.currentThread());
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10001));
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted " + Thread.currentThread());
            }
            return Thread.currentThread().toString();
        };

        List<Callable<String>> list = List.of(callable, callable, callable, callable);
        try {
            System.out.println("Thread that returned first " + pool.invokeAny(list));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        pool.shutdownNow();
    }

    static private void basicExecutionService () {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                System.out.println("Running start " + Thread.currentThread());
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10001));
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted " + Thread.currentThread());
                }
                System.out.println("Running end " + Thread.currentThread());
            });
        }
        try {
            if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }
    }

    static private void waitFutureResult () {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Future<String> future = pool.submit(() -> "result");

        try {
            System.out.println("This is returned from Async " + future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        pool.shutdownNow();
    }

}
