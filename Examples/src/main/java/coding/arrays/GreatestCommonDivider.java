package coding.arrays;

public class GreatestCommonDivider {

    public String gcdOfStrings(String str1, String str2) {
        // Check if the strings can have a common divisor
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find the GCD of the lengths
        int gcdLength = gcd(str1.length(), str2.length());

        // Return the prefix of that length
        return str1.substring(0, gcdLength);
    }

    // Helper method to find the greatest common divisor of two numbers
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static void main() {
        GreatestCommonDivider greatestCommonDivider = new GreatestCommonDivider();
        System.out.println(greatestCommonDivider.gcdOfStrings("ABABABAB", "ABAB"));
    }
}
