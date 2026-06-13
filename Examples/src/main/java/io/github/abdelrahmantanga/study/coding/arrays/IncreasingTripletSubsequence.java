package io.github.abdelrahmantanga.study.coding.arrays;

public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;
        int lowest = Integer.MAX_VALUE;
        int secLowest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= lowest) {
                lowest = nums[i];
            } else if (nums[i] <= secLowest) {
                secLowest = nums[i];
            } else  {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test Case 1 (Expected: true)
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Test 1: " + increasingTriplet(nums1));

        // Test Case 2 (Expected: false)
        int[] nums2 = {5, 4, 3, 2, 1};
        System.out.println("Test 2: " + increasingTriplet(nums2));

        // Test Case 3 (Expected: true)
        int[] nums3 = {2, 1, 5, 0, 4, 6};
        System.out.println("Test 3: " + increasingTriplet(nums3));

        int[] nums4 = {1,1,-2,6};
        System.out.println("Test 4: " + increasingTriplet(nums4));

    }
}
