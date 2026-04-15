public class Solution {
    public int reverse(int n) {
        int rev = 0;

        while (n != 0) {
            int digit = n % 10;

            if (rev > Integer.MAX_VALUE / 10 ||
                    rev < Integer.MIN_VALUE / 10) {
                return 0;
            }

            rev = rev * 10 + digit;
            n = n / 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] testCases = {
                12345,     // số dương
                -9876,     // số âm
                1200,      // có số 0 ở cuối
                0,         // số 0
                1534236469 // số có thể gây overflow
        };

        for (int n : testCases) {
            System.out.println("So ban dau: " + n);
            System.out.println("So dao nguoc: " + sol.reverse(n));
            System.out.println("----------------------");
        }
    }
}