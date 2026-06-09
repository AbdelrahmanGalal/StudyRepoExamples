package coding.arrays;

import java.util.Arrays;

public class StockPrices {

    /**
     * CHALLENGE 1: The Low-Latency Telemetry Window
     *
     * TIME COMPLEXITY: O(N) | Single pass rolling window
     * AUXILIARY SPACE: O(1) | Zero allocations in hot path
     */
    public static int calculatePeakVolume(int[] prices, int window) {
        if (prices == null || prices.length == 0 || window <= 0) {
            return 0;
        }

        int maxVolume = 0;

        // Edge Case: Array size is smaller than the requested window size
        if (prices.length < window) {
            for (int i = 0; i < prices.length; i++) {
                maxVolume += prices[i];
            }
            return maxVolume;
        } else {
            // Initialize the first window
            for (int i = 0; i < window; i++) {
                maxVolume += prices[i];
            }
        }

        // Slide the window across the remaining telemetry data
        int rollingWindowVolume = maxVolume;
        for (int i = window; i < prices.length; i++) {
            rollingWindowVolume += (prices[i] - prices[i - window]);
            maxVolume = Math.max(maxVolume, rollingWindowVolume);
        }

        return maxVolume;
    }

    public static void main(String[] args) {
        System.out.println("--- Challenge 1: Telemetry Window Verification --- \n");

        // Test Case 1: Standard shifting windows
        int[] prices1 = {2, 1, 5, 1, 3, 2, 9};
        int window1 = 3;
        printResult(1, prices1, window1, calculatePeakVolume(prices1, window1));
        // Expected: 14 (sub-array {3, 2, 9})

        // Test Case 2: Window size exactly matches array length
        int[] prices2 = {1, 2, 3};
        int window2 = 3;
        printResult(2, prices2, window2, calculatePeakVolume(prices2, window2));
        // Expected: 6

        // Test Case 3: Array length is shorter than window limit
        int[] prices3 = {4, 5};
        int window3 = 5;
        printResult(3, prices3, window3, calculatePeakVolume(prices3, window3));
        // Expected: 9
    }

    private static void printResult(int testNo, int[] prices, int window, int result) {
        System.out.printf("Test #%d | Prices: %s, Window: %d%n", testNo, Arrays.toString(prices), window);
        System.out.printf("         | Peak Calculated Volume: %d%n%n", result);
    }
}
