public class Solution {

    public int sumOfDigits(int n) {

        if (n < 0) {
            n = -n;
        }

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n = n / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 12345;
        int n2 = -9087;
        int n3 = 0;
        int n4 = 7;

        System.out.println("Sum of digits of " + n1 + " = " + sol.sumOfDigits(n1));
        System.out.println("Sum of digits of " + n2 + " = " + sol.sumOfDigits(n2));
        System.out.println("Sum of digits of " + n3 + " = " + sol.sumOfDigits(n3));
        System.out.println("Sum of digits of " + n4 + " = " + sol.sumOfDigits(n4));
    }
}