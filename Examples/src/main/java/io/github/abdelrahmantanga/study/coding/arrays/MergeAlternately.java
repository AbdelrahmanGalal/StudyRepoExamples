package io.github.abdelrahmantanga.study.coding.arrays;

public class MergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        char[] characters1 = word1.toCharArray();
        char[] characters2 = word2.toCharArray();
        int length = word1.length();
        if (word2.length() < word1.length())
            length = word2.length();
        for (int i = 0; i < length; i++) {
            sb.append(characters1[i]).append(characters2[i]);
        }
        if (word1.length() != word2.length()) {
            if (word1.length() > word2.length())
                sb.append(word1.substring(length));
            else
                sb.append(word2.substring(length));
        }
        return sb.toString();
    }

}
