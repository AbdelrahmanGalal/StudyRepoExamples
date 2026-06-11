package coding.slidingwindow;

public class MaxVowels {

    public static int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int maxVowels = 0;
        int currentWindow = 0;

        // Count first window
        for (int i = 0; i < k; i++) {
            if (isVowel(chars[i])) currentWindow++;
        }
        maxVowels = currentWindow;

        // Slide window
        for (int i = k; i < chars.length; i++) {
            if (maxVowels == k) return k; // Early exit optimization

            if (isVowel(chars[i])) currentWindow++;       // Add incoming character
            if (isVowel(chars[i - k])) currentWindow--;   // Remove outgoing character

            if (currentWindow > maxVowels) {
                maxVowels = currentWindow;
            }
        }
        return maxVowels;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u';
    }

    public static void main(String[] args) {
        System.out.println("--- Max Vowels in Substring Verification --- \n");

        // Test Case 1: Standard string with a concentrated block of vowels
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.printf("String: \"%s\" | k: %d%n", s1, k1);
        System.out.println("Max Vowels: " + maxVowels(s1, k1) + " (Expected: 3)\n");

        // Test Case 2: Pure vowel string
        String s2 = "aeiou";
        int k2 = 2;
        System.out.printf("String: \"%s\" | k: %d%n", s2, k2);
        System.out.println("Max Vowels: " + maxVowels(s2, k2) + " (Expected: 2)\n");

        // Test Case 3: Mixed words
        String s3 = "leetcode";
        int k3 = 3;
        System.out.printf("String: \"%s\" | k: %d%n", s3, k3);
        System.out.println("Max Vowels: " + maxVowels(s3, k3) + " (Expected: 2)\n");
    }
}
