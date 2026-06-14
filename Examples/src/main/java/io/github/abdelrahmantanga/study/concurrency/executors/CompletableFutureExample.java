package io.github.abdelrahmantanga.study.concurrency.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    static void main() throws InterruptedException {

        try (ExecutorService pool = Executors.newSingleThreadExecutor()) {
            CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "    This    is   a    messy    String     ", pool);
            cf.thenApply(s -> s.trim())
                    .thenApplyAsync(s -> s.concat(" Added My note "))
                    .thenCompose(s -> CompletableFuture.completedFuture(s + " test this "))
                    .thenCombine(CompletableFuture.completedFuture(" First value "), (first, second) -> first + second)
                    .thenAccept(System.out::println);
        }
    }
}
