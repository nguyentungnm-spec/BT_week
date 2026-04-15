public class Solution {
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("gcd(48, 18) = " + solution.gcd(48, 18));
        System.out.println("gcd(100, 25) = " + solution.gcd(100, 25));
        System.out.println("gcd(7, 3) = " + solution.gcd(7, 3));
        System.out.println("gcd(0, 5) = " + solution.gcd(0, 5));
        System.out.println("gcd(5, 0) = " + solution.gcd(5, 0));
        System.out.println("gcd(0, 0) = " + solution.gcd(0, 0));
        System.out.println("gcd(-12, 18) = " + solution.gcd(-12, 18));
    }
}