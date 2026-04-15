import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số lượng mảng n
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        PrimeCounter[] threads = new PrimeCounter[n];

        // Nhập dữ liệu cho từng mảng và khởi tạo luồng
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            threads[i] = new PrimeCounter(arr, i);
            threads[i].start(); // Chạy luồng song song
        }

        try {
            // Đợi tất cả các luồng kết thúc
            for (int i = 0; i < n; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Xuất kết quả và tìm giá trị lớn nhất
        int maxPrimes = -1;
        for (int i = 0; i < n; i++) {
            int count = threads[i].getPrimeCount();
            System.out.println("Array " + i + ": " + count);
            if (count > maxPrimes) {
                maxPrimes = count;
            }
        }

        // Tìm các mảng có số lượng số nguyên tố bằng maxPrimes
        List<Integer> bestArrays = new ArrayList<>();
        if (maxPrimes >= 0) {
            for (int i = 0; i < n; i++) {
                if (threads[i].getPrimeCount() == maxPrimes) {
                    bestArrays.add(i);
                }
            }

            // In kết luận cuối cùng
            for (int i = 0; i < bestArrays.size(); i++) {
                int idx = bestArrays.get(i);
                System.out.println("Most primes: Array " + idx + " with " + maxPrimes + " primes");
            }
        }

        sc.close();
    }
}