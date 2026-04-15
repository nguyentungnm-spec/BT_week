public class Solution {
    public boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        if (n <= 3) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] testNumbers = {-5, 0, 1, 2, 3, 4, 17, 25, 97, 1000003};

        for (int n : testNumbers) {
            System.out.println(n + " -> " + solution.isPrime(n));
        }
    }
}