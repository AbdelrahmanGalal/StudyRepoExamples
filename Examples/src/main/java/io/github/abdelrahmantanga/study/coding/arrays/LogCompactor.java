package io.github.abdelrahmantanga.study.coding.arrays;

import java.util.Arrays;

public class LogCompactor {

    /**
     * CHALLENGE 3: In-Place Log Compaction
     *
     * TIME COMPLEXITY TARGET: O(N)
     * AUXILIARY SPACE TARGET: O(1)
     *
     * @param logs The array of transaction payload IDs to compact.
     * @param val The specific error code payload value to remove.
     * @return The new valid length of the array after compaction.
     */
    public static int compactLogs(int[] logs, int val) {
        int writePointer = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i] != val) {
                logs[writePointer] = logs[i];
                writePointer++;
            }
        }
        return writePointer;
    }

    public static void main(String[] args) {
        System.out.println("--- Challenge 3: Log Compaction Verification --- \n");

        // Test Case 1: Standard truncation
        int[] logs1 = {3, 2, 2, 3};
        int val1 = 3;
        int len1 = compactLogs(logs1, val1);
        System.out.printf("Test 1 | New Length: %d, Array: %s%n", len1, Arrays.toString(Arrays.copyOf(logs1, len1)));
        // Expected Length: 2, Elements: [2, 2]

        // Test Case 2: All elements match the error code
        int[] logs2 = {1, 1, 1};
        int val2 = 1;
        int len2 = compactLogs(logs2, val2);
        System.out.printf("Test 2 | New Length: %d, Array: %s%n", len2, Arrays.toString(Arrays.copyOf(logs2, len2)));
        // Expected Length: 0, Elements: []
    }
}
