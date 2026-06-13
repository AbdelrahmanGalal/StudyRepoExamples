package io.github.abdelrahmantanga.study.coding.prefixSum;

import java.util.Arrays;

public class PivotIndex {

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = sum;
            sum += nums[i];
        }
        int end = nums.length - 1;
        int index = -1;
        sum = 0;
        while (end >= 0) {
            if (sum == arr[end]) {
                index = end;
            }
            sum += nums[end];
            end--;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println("--- Find Pivot Index Verification --- \n");

//        // Test Case 1: Standard case with pivot in the middle
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println("Array: " + Arrays.toString(nums1));
        System.out.println("Pivot Index: " + pivotIndex(nums1) + " (Expected: 3)\n");

        // Test Case 2: No valid pivot index exists
        int[] nums2 = {1, 2, 3};
        System.out.println("Array: " + Arrays.toString(nums2));
        System.out.println("Pivot Index: " + pivotIndex(nums2) + " (Expected: -1)\n");

        // Test Case 3: Pivot index is at the very beginning (index 0)
        int[] nums3 = {2, 1, -1};
        System.out.println("Array: " + Arrays.toString(nums3));
        System.out.println("Pivot Index: " + pivotIndex(nums3) + " (Expected: 0)\n");

        // Test Case 4: Pivot index is at the very end
        int[] nums4 = {-1, 1, 0};
        System.out.println("Array: " + Arrays.toString(nums4));
        System.out.println("Pivot Index: " + pivotIndex(nums4) + " (Expected: 2)\n");
    }
}
