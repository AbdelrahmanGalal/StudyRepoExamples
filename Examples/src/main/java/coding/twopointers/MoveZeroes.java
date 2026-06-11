package coding.twopointers;

import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int offset = 1;
        int index = 0;
        while (offset < nums.length && index < nums.length) {
            if (nums[index] == 0) {
                while (offset < nums.length - 1 && nums[offset] == 0) {
                    offset ++;
                }
                nums[index] = nums[offset];
                nums[offset] = 0;
                offset++;
                index++;
            } else {
                index++;
                if (index >= offset){
                    offset++;
                }
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("--- Move Zeroes Verification --- \n");

        // Test Case 1: Standard mixed array
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("Before: " + Arrays.toString(nums1));
        moveZeroes(nums1);
        System.out.println("After:  " + Arrays.toString(nums1) + " (Expected: [1, 3, 12, 0, 0])\n");

        // Test Case 2: Single zero element
        int[] nums2 = {0};
        System.out.println("Before: " + Arrays.toString(nums2));
        moveZeroes(nums2);
        System.out.println("After:  " + Arrays.toString(nums2) + " (Expected: [0])\n");

        // Test Case 3: No zeroes present
        int[] nums3 = {4, 5, 6};
        System.out.println("Before: " + Arrays.toString(nums3));
        moveZeroes(nums3);
        System.out.println("After:  " + Arrays.toString(nums3) + " (Expected: [4, 5, 6])\n");
    }
}
