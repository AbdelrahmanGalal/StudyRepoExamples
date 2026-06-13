package io.github.abdelrahmantanga.study.coding.arrays;

public class ReverseVowels {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        char c1;
        char c2;

        int start = 0;
        int end = chars.length - 1;

        if (start == end)
            return s;

        while (start < end) {
            while (start < chars.length && !checkIsVowel(chars[start]))
                start++;

            while (end > 0 && !checkIsVowel(chars[end]))
                end--;
            if (end > start) {
                c1 = chars[start];
                c2 = chars[end];
                chars[start] = c2;
                chars[end] = c1;
                start ++;
                end --;
            }
        }
        return String.valueOf(chars);
    }

    boolean checkIsVowel (char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (int i =0; i < vowels.length; i++) {
            if (vowels[i] == c)
                return true;
        }
        return false;
    }

    static void main() {
        ReverseVowels v = new ReverseVowels();
        System.out.println(v.reverseVowels("IceCreAm"));
    }
}
