package io.github.abdelrahmantanga.study.concurrency.collections;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayExample {
    static void main() {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Writes: clone the entire array — O(n), use only for infrequent writes
        list.add("item");
        list.set(0, "updated");
        list.remove("item");

        // Reads: always on a stable snapshot — O(1), never blocks, never throws CME
        list.get(0);
        list.size();

        // Safe iteration — iterates a snapshot taken at iterator creation time
        for (String s : list) { /* always safe, even concurrent writes */ }

        // PRIMARY USE CASE: event listener / observer lists
        // Few registrations (writes), many dispatches (reads)
    }
}
