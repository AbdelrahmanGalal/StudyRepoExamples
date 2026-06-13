package io.github.abdelrahmantanga.study.coding.arrays;

public class ReverseWords {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] s1 = s.split(" ");
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals(""))
                continue;
            sb.append(s1[i]);
            if (i != 0)
                sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords solution = new ReverseWords();

        // Test Case 1: Standard sentence
        String test1 = "the sky is blue";
        System.out.println("Input:  \"" + test1 + "\"");
        System.out.println("Output: \"" + solution.reverseWords(test1) + "\"\n");

        // Test Case 2: Leading and trailing spaces
        String test2 = "  hello world  ";
        System.out.println("Input:  \"" + test2 + "\"");
        System.out.println("Output: \"" + solution.reverseWords(test2) + "\"\n");

        // Test Case 3: Multiple spaces between words
        String test3 = "a good   example";
        System.out.println("Input:  \"" + test3 + "\"");
        System.out.println("Output: \"" + solution.reverseWords(test3) + "\"\n");
    }
}
