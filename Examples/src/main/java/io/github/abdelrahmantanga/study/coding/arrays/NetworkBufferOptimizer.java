package io.github.abdelrahmantanga.study.coding.arrays;

import java.util.Arrays;

public class NetworkBufferOptimizer {

    /**
     * CHALLENGE 4: Maximizing Network Packet Buffer Window
     *
     * TIME COMPLEXITY TARGET: O(N)
     * AUXILIARY SPACE TARGET: O(1)
     */
    public static int maxBufferCapacity(int[] nodes) {
        int start= 0;
        int end = nodes.length - 1;
        int optimizer = 0;
        while (start < end) {
            int currentOptimizer = (Math.min(nodes[start], nodes[end])) * (end - start);
            if (currentOptimizer > optimizer) {
                optimizer = currentOptimizer;
            }
            if (nodes[start] > nodes[end])
                end--;
            else
                start++;
        }
        return optimizer;
    }

    public static void main(String[] args) {
        System.out.println("--- Challenge 4: Network Buffer Verification --- \n");

        // Test Case 1: Standard varying topology
        int[] nodes1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        printResult(1, nodes1, maxBufferCapacity(nodes1)); // Expected: 49 (Indices 1 and 8: min(8,7) * (8-1) = 7 * 7 = 49)

        // Test Case 2: Uniform low capacity nodes
        int[] nodes2 = {1, 1};
        printResult(2, nodes2, maxBufferCapacity(nodes2)); // Expected: 1

        // Test Case 3: Decreasing capacity staircase
        int[] nodes3 = {4, 3, 2, 1};
        printResult(3, nodes3, maxBufferCapacity(nodes3)); // Expected: 4
    }

    private static void printResult(int testNo, int[] nodes, int result) {
        System.out.printf("Test #%d | Nodes: %s%n", testNo, Arrays.toString(nodes));
        System.out.printf("         | Maximum Channel Capacity: %d%n%n", result);
    }
}