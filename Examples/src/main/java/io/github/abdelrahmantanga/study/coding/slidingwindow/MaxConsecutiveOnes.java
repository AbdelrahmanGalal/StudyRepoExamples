package io.github.abdelrahmantanga.study.coding.slidingwindow;

import java.util.Arrays;

public class MaxConsecutiveOnes {

    public static int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int available = k;
        int maxWindow = 0;
        while (end < nums.length) {
            if (nums[end] == 1) {
                end++;
            } else {
                if (available > 0) {
                    end ++;
                    available--;
                } else {
                    start++;
                    if (nums[start - 1] == 0) {
                        available++;
                    }
                }
            }
            maxWindow = Math.max(maxWindow, end - start);
        }

        return maxWindow;
    }

    public static void main(String[] args) {
        System.out.println("--- Max Consecutive Ones III Verification --- \n");

        // Test Case 1: Standard binary array
        int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        System.out.printf("Array: %s | k: %d%n", Arrays.toString(nums1), k1);
        System.out.println("Max Consecutive 1s: " + longestOnes(nums1, k1) + " (Expected: 6)\n");

        // Test Case 2: Longer array with more zeroes allowed
        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k2 = 3;
        System.out.printf("Array: %s | k: %d%n", Arrays.toString(nums2), k2);
        System.out.println("Max Consecutive 1s: " + longestOnes(nums2, k2) + " (Expected: 10)\n");

        // Test Case 3: No flips allowed
        int[] nums3 = {1, 1, 0, 1};
        int k3 = 0;
        System.out.printf("Array: %s | k: %d%n", Arrays.toString(nums3), k3);
        System.out.println("Max Consecutive 1s: " + longestOnes(nums3, k3) + " (Expected: 2)\n");
    }
}
