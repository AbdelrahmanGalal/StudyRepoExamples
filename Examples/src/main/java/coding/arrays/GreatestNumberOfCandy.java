package coding.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestNumberOfCandy {

    /**
     * Identifies which kids can have the greatest number of candies
     * after receiving the extra allocation.
     *
     * TIME COMPLEXITY: O(N) | Two linear passes
     * SPACE COMPLEXITY: O(N) | To store the result list
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> list = new ArrayList<>();
        int gnoc = 0; // Greatest Number Of Candies

        // Pass 1: Find the current maximum candy distribution
        for (int i = 0; i < candies.length; i++) {
            if (gnoc < candies[i]) {
                gnoc = candies[i];
            }
        }

        // Pass 2: Evaluate each child with extra candies included
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= gnoc) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println("--- Candy Distribution Verification Engine --- \n");
        GreatestNumberOfCandy engine = new GreatestNumberOfCandy();

        // Test Case 1: Standard distribution mix
        int[] candies1 = {2, 3, 5, 1, 3};
        int extra1 = 3;
        printResult(1, candies1, extra1, engine.kidsWithCandies(candies1, extra1));
        // Expected: [true, true, true, false, true]

        // Test Case 2: Small distribution where everyone qualifies
        int[] candies2 = {4, 2, 1, 1, 2};
        int extra2 = 1;
        printResult(2, candies2, extra2, engine.kidsWithCandies(candies2, extra2));
        // Expected: [true, false, false, false, false]

        // Test Case 3: Single child edge-case boundary
        int[] candies3 = {12};
        int extra3 = 10;
        printResult(3, candies3, extra3, engine.kidsWithCandies(candies3, extra3));
        // Expected: [true]
    }

    private static void printResult(int testNo, int[] candies, int extra, List<Boolean> result) {
        System.out.printf("Test #%d | Candies: %s, Extra: %d%n", testNo, Arrays.toString(candies), extra);
        System.out.printf("         | Target Result: %s%n%n", result.toString());
    }
}
