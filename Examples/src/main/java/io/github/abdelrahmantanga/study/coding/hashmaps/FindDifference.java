package io.github.abdelrahmantanga.study.coding.hashmaps;

import java.util.*;

public class FindDifference {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Your code here
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        set1.removeAll(set2);
        set2.removeAll(Arrays.stream(nums1)
                .boxed()
                .toList());

        List<List<Integer>> result = new ArrayList<>();
        result.add(set1.stream().toList());
        result.add(set2.stream().toList());
        return result;
    }

    public static void main(String[] args) {
        System.out.println("--- Find the Difference of Two Arrays Verification --- \n");

        // Test Case 1: Standard case with partial overlaps
        int[] nums1_1 = {1, 2, 3};
        int[] nums2_1 = {2, 4, 6};
        System.out.println("Arrays: " + Arrays.toString(nums1_1) + " and " + Arrays.toString(nums2_1));
        System.out.println("Result: " + findDifference(nums1_1, nums2_1) + " (Expected: [[1, 3], [4, 6]])\n");

        // Test Case 2: One array's elements completely contained in the other, with duplicates
        int[] nums1_2 = {1, 2, 3, 3};
        int[] nums2_2 = {1, 1, 2, 2};
        System.out.println("Arrays: " + Arrays.toString(nums1_2) + " and " + Arrays.toString(nums2_2));
        System.out.println("Result: " + findDifference(nums1_2, nums2_2) + " (Expected: [[3], []])\n");

        // Test Case 3: Complete overlap
        int[] nums1_3 = {1, 2, 2};
        int[] nums2_3 = {2, 1, 1};
        System.out.println("Arrays: " + Arrays.toString(nums1_3) + " and " + Arrays.toString(nums2_3));
        System.out.println("Result: " + findDifference(nums1_3, nums2_3) + " (Expected: [[], []])\n");
    }
}