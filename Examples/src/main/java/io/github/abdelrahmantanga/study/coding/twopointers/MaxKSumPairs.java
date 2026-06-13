package io.github.abdelrahmantanga.study.coding.twopointers;

import java.util.Arrays;

public class MaxKSumPairs {

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int operations = 0;
        int start = 0;
        int end = nums.length - 1;
        while ( start < end) {
            if (nums[start] + nums[end] == k) {
                operations++;
                start++;
                end--;
            } else if (nums[start] + nums[end] > k) {
                end --;
            } else {
                start++;
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        System.out.println("--- Max Number of K-Sum Pairs Verification --- \n");

        // Test Case 1: Complete pairing
        int[] nums1 = {1, 2, 3, 4};
        int k1 = 5;
        System.out.printf("Array: %s | Target k: %d%n", Arrays.toString(nums1), k1);
        System.out.println("Max Operations: " + maxOperations(nums1, k1) + " (Expected: 2)\n");

        // Test Case 2: Duplicate numbers with leftover elements
        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;
        System.out.printf("Array: %s | Target k: %d%n", Arrays.toString(nums2), k2);
        System.out.println("Max Operations: " + maxOperations(nums2, k2) + " (Expected: 1)\n");

        // Test Case 3: No valid pairs
        int[] nums3 = {1, 5, 7};
        int k3 = 4;
        System.out.printf("Array: %s | Target k: %d%n", Arrays.toString(nums3), k3);
        System.out.println("Max Operations: " + maxOperations(nums3, k3) + " (Expected: 0)\n");
    }
}
