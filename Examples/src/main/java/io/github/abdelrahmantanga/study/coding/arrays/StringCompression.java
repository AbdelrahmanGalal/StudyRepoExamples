package io.github.abdelrahmantanga.study.coding.arrays;

public class StringCompression {

     public int compress(char[] chars) {
        if (chars.length == 0)
            return 0;
        char c = ' ';
        int count = 0;
        int writeIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                count++;
            } else {
                if (c == ' ') {
                    c = chars[i];
                    count= 1;
                    continue;
                }
                chars[writeIndex] = c;
                writeIndex++;
                if (count > 1) {
                    char[] str = String.valueOf(count).toCharArray();
                    for (int number = 0; number < str.length; number++) {
                        chars[writeIndex++] = str[number];
                    }
                }
                c = chars[i];
                count = 1;
            }
        }
         chars[writeIndex] = c;
         writeIndex++;
         if (count > 1) {
             char[] str = String.valueOf(count).toCharArray();
             for (int number = 0; number < str.length; number++) {
                 chars[writeIndex++] = str[number];
             }
         }
        return writeIndex;
    }

    public static void main(String[] args) {
        StringCompression solver = new StringCompression();

        // Test Case 1
        char[] test1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int len1 = solver.compress(test1);
        printResult(1, test1, len1, 6);

        // Test Case 2
        char[] test2 = {'a'};
        int len2 = solver.compress(test2);
        printResult(2, test2, len2, 1);

        // Test Case 3
        char[] test3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int len3 = solver.compress(test3);
        printResult(3, test3, len3, 4);
    }

    // Helper method to print and verify the outputs
    private static void printResult(int caseNum, char[] chars, int newLength, int expectedLength) {
        System.out.println("--- Test Case " + caseNum + " ---");
        System.out.println("Returned Length: " + newLength + " (Expected: " + expectedLength + ")");
        System.out.print("Modified Array: [");
        for (int i = 0; i < newLength; i++) {
            System.out.print("'" + chars[i] + "'" + (i < newLength - 1 ? ", " : ""));
        }
        System.out.println("]");
        System.out.println("Status: " + (newLength == expectedLength ? "PASS" : "FAIL") + "\n");
    }
}


