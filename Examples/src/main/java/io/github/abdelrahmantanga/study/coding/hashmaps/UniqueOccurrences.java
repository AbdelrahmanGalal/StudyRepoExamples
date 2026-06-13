package io.github.abdelrahmantanga.study.coding.hashmaps;

import java.util.Arrays;
import java.util.HashMap;

public class UniqueOccurrences {

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.get(num) == null) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        return map.values().stream().distinct().count() == map.keySet().stream().count();
    }

    public static void main(String[] args) {
        System.out.println("--- Unique Number of Occurrences Verification --- \n");

        // Test Case 1: Standard case where frequencies are all unique
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Result: " + uniqueOccurrences(arr1) + " (Expected: true)\n");

        // Test Case 2: Duplicate frequencies present (both 1 and 2 appear once)
        int[] arr2 = {1, 2};
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Result: " + uniqueOccurrences(arr2) + " (Expected: false)\n");

        // Test Case 3: Mixed positive, negative, and zero values with unique frequencies
        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("Result: " + uniqueOccurrences(arr3) + " (Expected: true)\n");
    }
}
