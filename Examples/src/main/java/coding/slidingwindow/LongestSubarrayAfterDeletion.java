package coding.slidingwindow;

import java.util.Arrays;

public class LongestSubarrayAfterDeletion {

    public static int longestSubarray(int[] nums) {
        int max = 0;
        int start = 0;
        int end = 0;
        boolean deleted = false;

        while (end < nums.length) {
            if (nums[end] == 1) {
                end++;
            } else {
                if (!deleted) {
                    end++;
                    deleted = true;
                } else {
                    start++;
                    if (nums[start - 1] == 0) {
                        deleted = false;
                    }
                }
            }
            max = Math.max(max, end - start - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("--- Longest Subarray After Deleting One Element Verification --- \n");

        // Test Case 1: Single zero to delete
        int[] nums1 = {1, 1, 0, 1};
        System.out.println("Array: " + Arrays.toString(nums1));
        System.out.println("Longest Subarray: " + longestSubarray(nums1) + " (Expected: 3)\n");

        // Test Case 2: Multiple zeroes present
        int[] nums2 = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println("Array: " + Arrays.toString(nums2));
        System.out.println("Longest Subarray: " + longestSubarray(nums2) + " (Expected: 5)\n");

        // Test Case 3: All ones (must still delete one element)
        int[] nums3 = {1, 1, 1};
        System.out.println("Array: " + Arrays.toString(nums3));
        System.out.println("Longest Subarray: " + longestSubarray(nums3) + " (Expected: 2)\n");
    }
}
