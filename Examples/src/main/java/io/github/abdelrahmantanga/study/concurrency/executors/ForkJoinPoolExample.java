package io.github.abdelrahmantanga.study.concurrency.executors;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

public class ForkJoinPoolExample {

    static void main() {
        System.out.println("Fork Join example for large array sum");
        System.out.println("-------------------------------------------------------\n\n");

        ForkJoinPool pool = ForkJoinPool.commonPool();
        int[] data = ThreadLocalRandom.current()
                .ints(10_000_000, 1, 11)
                .toArray();
        Long total = pool.invoke(new SumTask(data, 0, data.length));
        pool.shutdown();

        System.out.println("Total with Fork is " + total);

        System.out.println("Total with streams is " + Arrays.stream(data).sum());
    }

    static class SumTask extends RecursiveTask<Long> {

        static final int THRESHOLD = 1_000;
        private final int[] arr;
        private final int lo, hi;

        SumTask (int[] arr, int lo, int hi) {
            this.arr = arr;
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        protected Long compute() {
            long sum = 0;
            if (hi - lo <= THRESHOLD) {
                for (int i = lo; i < hi; i++) sum += arr[i];
                return sum;
            }

            int mid = (hi + lo) / 2;
            SumTask left = new SumTask(arr, lo, mid);
            SumTask right = new SumTask(arr, mid, hi);

            left.fork();
            Long rightVal = right.compute();
            Long leftVal = left.join();
            return rightVal + leftVal;
        }
    }
}
