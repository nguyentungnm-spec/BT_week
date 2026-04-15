public class Solution {
    public long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }

        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0; // F(0)
        long b = 1; // F(1)

        for (long i = 2; i <= n; i++) {

            if (Long.MAX_VALUE - b < a) {
                return Long.MAX_VALUE;
            }

            long c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println("F(0) = " + sol.fibonacci(0));
        System.out.println("F(1) = " + sol.fibonacci(1));
        System.out.println("F(5) = " + sol.fibonacci(5));
        System.out.println("F(10) = " + sol.fibonacci(10));
        System.out.println("F(-3) = " + sol.fibonacci(-3));
        System.out.println("F(100) = " + sol.fibonacci(100));
    }
}