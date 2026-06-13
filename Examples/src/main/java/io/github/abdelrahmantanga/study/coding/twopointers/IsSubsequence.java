package io.github.abdelrahmantanga.study.coding.twopointers;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        if ("".equals(s))
            return true;

        String smaller = s;
        String bigger = t;

        int index = 0;
        boolean found = false;
        for (int i = 0; i < smaller.length(); i++) {
            char c = smaller.charAt(i);
            found = false;
            while (index < bigger.length() && !found) {
                if (bigger.charAt(index) == c)
                    found = true;
                index++;
            }
            if (!found)
                return found;
        }
        return found;
    }

    public static void main(String[] args) {
        System.out.println("--- Is Subsequence Verification --- \n");

        // Test Case 1: Valid subsequence
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.printf("s: \"%s\" | t: \"%s\"%n", s1, t1);
        System.out.println("Result: " + isSubsequence(s1, t1) + " (Expected: true)\n");

        // Test Case 2: Invalid subsequence (wrong characters / order)
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.printf("s: \"%s\" | t: \"%s\"%n", s2, t2);
        System.out.println("Result: " + isSubsequence(s2, t2) + " (Expected: false)\n");

        // Test Case 3: Empty string 's' (always a valid subsequence)
        String s3 = "";
        String t3 = "ahbgdc";
        System.out.printf("s: \"%s\" | t: \"%s\"%n", s3, t3);
        System.out.println("Result: " + isSubsequence(s3, t3) + " (Expected: true)\n");

        String s4 = "b";
        String t4 = "c";
        System.out.printf("s: \"%s\" | t: \"%s\"%n", s4, t4);
        System.out.println("Result: " + isSubsequence(s4, t4) + " (Expected: false)\n");
    }
}
