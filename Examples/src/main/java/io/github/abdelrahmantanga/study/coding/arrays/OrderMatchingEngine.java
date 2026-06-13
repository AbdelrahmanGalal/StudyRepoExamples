package io.github.abdelrahmantanga.study.coding.arrays;

import java.util.Arrays;

public class OrderMatchingEngine {

    /**
     * CHALLENGE 2: Memory-Efficient Order Matching Engine
     *
     * TIME COMPLEXITY TARGET: O(N)
     * AUXILIARY SPACE TARGET: O(1)
     *
     * @param orders A sorted array of unique order IDs.
     * @param target The exact sum targeted for matching.
     * @return An int array containing the two indices of the matching orders,
     *         or an empty array int[0] if no match exists.
     */
    public static int[] findMatchingOrders(int[] orders, int target) {
        int start = 0;
        int end = orders.length - 1;
        int[] answer = new int[2];
        while (start < end) {
            if (orders[start] + orders[end] == target) {
                return new int[] {start, end};
            } else if (orders[start] + orders[end] > target){
                end--;
            } else {
                start++;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println("--- Challenge 2: Order Matching Verification --- \n");

        // Test Case 1: Standard match
        int[] orders1 = {1, 2, 3, 4, 6};
        int target1 = 6;
        printResult(1, orders1, target1, findMatchingOrders(orders1, target1)); // Expected: [1, 3] (elements 2 + 4)

        // Test Case 2: Matching with negative IDs
        int[] orders2 = {-5, -2, 0, 3, 7, 11};
        int target2 = 5;
        printResult(2, orders2, target2, findMatchingOrders(orders2, target2)); // Expected: [1, 4] (elements -2 + 7)

        // Test Case 3: No valid match available
        int[] orders3 = {1, 3, 5, 8};
        int target3 = 7;
        printResult(3, orders3, target3, findMatchingOrders(orders3, target3)); // Expected: [] (Empty array)

        // Test Case 4: Target using outermost elements
        int[] orders4 = {1, 2, 3, 4, 5, 15};
        int target4 = 16;
        printResult(4, orders4, target4, findMatchingOrders(orders4, target4)); // Expected: [0, 5] (elements 1 + 15)
    }

    private static void printResult(int testNo, int[] orders, int target, int[] result) {
        System.out.printf("Test #%d | Input: %s, Target: %d%n", testNo, Arrays.toString(orders), target);
        System.out.printf("         | Result Indices: %s%n%n", Arrays.toString(result));
    }
}
