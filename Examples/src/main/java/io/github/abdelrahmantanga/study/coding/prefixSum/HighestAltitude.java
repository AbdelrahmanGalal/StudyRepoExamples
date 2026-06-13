package io.github.abdelrahmantanga.study.coding.prefixSum;

import java.util.Arrays;

public class HighestAltitude {

    public static int largestAltitude(int[] gain) {
        int highest = 0;
        int height = 0;

        for (int i = 0; i < gain.length; i++) {
            height += gain[i];
            highest = Math.max(highest, height);
        }

        return highest;
    }

    public static void main(String[] args) {
        System.out.println("--- Highest Altitude Verification --- \n");

        // Test Case 1: Standard mix of gains and drops
        int[] gain1 = {-5, 1, 5, 0, -7};
        System.out.println("Gains: " + Arrays.toString(gain1));
        System.out.println("Highest Altitude: " + largestAltitude(gain1) + " (Expected: 1)\n");

        // Test Case 2: Continuous drops
        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println("Gains: " + Arrays.toString(gain2));
        System.out.println("Highest Altitude: " + largestAltitude(gain2) + " (Expected: 0)\n");

        // Test Case 3: Single positive gain
        int[] gain3 = {5};
        System.out.println("Gains: " + Arrays.toString(gain3));
        System.out.println("Highest Altitude: " + largestAltitude(gain3) + " (Expected: 5)\n");

        // Test Case 4: All negative gains
        int[] gain4 = {-1, -2, -3};
        System.out.println("Gains: " + Arrays.toString(gain4));
        System.out.println("Highest Altitude: " + largestAltitude(gain4) + " (Expected: 0)\n");
    }
}
