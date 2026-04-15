public class Solution {

    public int secondLargest(int[] arr) {

        if (arr == null || arr.length < 2) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : arr) {

            if (num > max) {
                secondMax = max;
                max = num;
            }

            else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            return -1;
        }

        return secondMax;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] arr1 = {3, 5, 1, 9, 7};
        int[] arr2 = {10, 10, 10};
        int[] arr3 = {8};
        int[] arr4 = {4, 2, 9, 9, 7, 6};

        System.out.println("Second largest arr1: " + sol.secondLargest(arr1));
        System.out.println("Second largest arr2: " + sol.secondLargest(arr2));
        System.out.println("Second largest arr3: " + sol.secondLargest(arr3));
        System.out.println("Second largest arr4: " + sol.secondLargest(arr4));
    }
}