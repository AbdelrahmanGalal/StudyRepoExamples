package io.github.abdelrahmantanga.study.concurrency.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BlockingLinkedQueueExample {

    static void main() throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(100); // bounded — always prefer in production
// ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(100); // fixed array; less GC pressure

// Producer (blocks if full)
        queue.put("item");                                // blocks
        boolean ok  = queue.offer("item");                // non-blocking; returns false if full
        boolean ok2 = queue.offer("item", 1, SECONDS);   // timed

// Consumer (blocks if empty)
        String item  = queue.take();                      // blocks
        String item2 = queue.poll();                      // non-blocking; returns null if empty
        String item3 = queue.poll(1, SECONDS);            // timed

// Bulk consume
        List<String> batch = new ArrayList<>();
        int drained = queue.drainTo(batch, 50);           // drain up to 50 items atomically
    }
}
