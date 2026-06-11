package coding.slidingwindow;

import java.util.Arrays;

public class MaximumAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {
        double maxAverage = -Double.MAX_VALUE;
        double currentAverage = 0.0f;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                currentAverage += nums[i];
            } else {
                maxAverage = Math.max(maxAverage, currentAverage);
                currentAverage = currentAverage + nums[i] - nums[i - k];
            }
        }
        maxAverage = Math.max(maxAverage, currentAverage);
        return maxAverage / k;
    }

    public static void main(String[] args) {
        System.out.println("--- Maximum Average Subarray I Verification --- \n");

        // Test Case 1: Standard mixed array
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.printf("Array: %s | k: %d%n", Arrays.toString(nums1), k1);
        System.out.printf("Max Average: %.5f (Expected: 12.75000)%n%n", findMaxAverage(nums1, k1));

        // Test Case 2: Single element array
        int[] nums2 = {5};
        int k2 = 1;
        System.out.printf("Array: %s | k: %d%n", Arrays.toString(nums2), k2);
        System.out.printf("Max Average: %.5f (Expected: 5.00000)%n%n", findMaxAverage(nums2, k2));

        // Test Case 3: All negative numbers
        int[] nums3 = {-1};
        int k3 = 1;
        System.out.printf("Array: %s | k: %d%n", Arrays.toString(nums3), k3);
        System.out.printf("Max Average: %.5f (Expected: -1.00000)%n%n", findMaxAverage(nums3, k3));

        // Test Case 4: Large dataset challenge
        int[] nums4 = {
                -6662, 5432, -8558, -8935, 8731, -3083, 4115, 9931, -4006, -3284, -3024, 1714, -2825, -2374, -2750
                , -959, 6516, 9356, 8040, -2169, -9490, -3068, 6299, 7823, -9767, 5751, -7897, 6680, -1293, -3486,
                -6785, 6337, -9158, -4183, 6240, -2846, -2588, -5458, -9576, -1501, -908, -5477, 7596, -8863, -4088,
                7922, 8231, -4928, 7636, -3994, -243, -1327, 8425, -3468, -4218, -364, 4257, 5690, 1035, 6217, 8880,
                4127, -6299, -1831, 2854, -4498, -6983, -677, 2216, -1938, 3348, 4099, 3591, 9076, 942, 4571, -4200,
                7271, -6920, -1886, 662, 7844, 3658, -6562, -2106, -296, -3280, 8909, -8352, -9413, 3513, 1352, -8825
        };
        int k4 = 90;
        System.out.printf("Large Array Size: %d | k: %d%n", nums4.length, k4);
        System.out.printf("Max Average: %.5f (Expected: 37.25556)%n%n", findMaxAverage(nums4, k4));
    }
}
