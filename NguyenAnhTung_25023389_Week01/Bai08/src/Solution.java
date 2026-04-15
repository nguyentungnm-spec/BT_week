public class Solution {
    public boolean isPalindrome(int n) {

        if (n < 0) {
            return false;
        }

        int original = n;
        int reverse = 0;

        while (n != 0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n = n / 10;
        }

        return original == reverse;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] testNumbers = {121, -121, 10, 12321, 1001, 12345};

        for (int n : testNumbers) {
            System.out.println(n + " -> " + sol.isPalindrome(n));
        }
    }
}