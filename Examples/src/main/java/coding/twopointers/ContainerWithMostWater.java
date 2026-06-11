package coding.twopointers;

import java.util.Arrays;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxWater = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int currentWater = (end - start) * Math.min(height[start], height[end]);
            maxWater = Math.max(maxWater, currentWater);
            if (height[start] < height[end])
                start++;
            else
                end--;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println("--- Container With Most Water Verification --- \n");

        // Test Case 1: Standard varying heights
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Heights: " + Arrays.toString(height1));
        System.out.println("Max Water: " + maxArea(height1) + " (Expected: 49)\n");

        // Test Case 2: Minimal uniform elements
        int[] height2 = {1, 1};
        System.out.println("Heights: " + Arrays.toString(height2));
        System.out.println("Max Water: " + maxArea(height2) + " (Expected: 1)\n");

        // Test Case 3: Decreasing staircase
        int[] height3 = {4, 3, 2, 1};
        System.out.println("Heights: " + Arrays.toString(height3));
        System.out.println("Max Water: " + maxArea(height3) + " (Expected: 4)\n");
    }
}
