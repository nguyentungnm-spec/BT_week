import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {

    // Kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng mảng n: ");
        int n = sc.nextInt();

        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(sc.nextInt());
            }
            arrays.add(list);
        }

        // Giai đoạn 1: Lọc số nguyên tố
        ExecutorService pool1 = Executors.newFixedThreadPool(4);
        // Giai đoạn 2: Tính toán tổng
        ExecutorService pool2 = Executors.newFixedThreadPool(4);

        List<CompletableFuture<Long>> futures = new ArrayList<>();

        // Biến lưu tổng cuối cùng (dùng Atomic để an toàn đa luồng)
        java.util.concurrent.atomic.AtomicLong finalTotal = new java.util.concurrent.atomic.AtomicLong(0);

        for (int i = 0; i < n; i++) {
            int arrayIndex = i;
            List<Integer> currentArray = arrays.get(i);

            // Giai đoạn 1
            CompletableFuture<List<Integer>> stage1 = CompletableFuture.supplyAsync(() -> {
                List<Integer> primes = currentArray.stream()
                        .filter(Main::isPrime)
                        .collect(Collectors.toList());
                System.out.println("Stage 1 - Array " + arrayIndex + ": " + primes);
                return primes;
            }, pool1);

            // Giai đoạn 2 (Tiếp nối ngay sau Giai đoạn 1)
            CompletableFuture<Long> stage2 = stage1.thenApplyAsync(primes -> {
                long result = 0;
                int size = primes.size();

                if (size % 2 == 0 && size > 0) {
                    // Chẵn: Tổng bình phương
                    result = primes.stream().mapToLong(x -> (long) x * x).sum();
                    System.out.println("Stage 2 - Array " + arrayIndex + ": sum of squares = " + result);
                } else if (size % 2 != 0) {
                    // Lẻ: Tổng lập phương
                    result = primes.stream().mapToLong(x -> (long) x * x * x).sum();
                    System.out.println("Stage 2 - Array " + arrayIndex + ": sum of cubes = " + result);
                } else {
                    System.out.println("Stage 2 - Array " + arrayIndex + ": no primes = 0");
                }
                return result;
            }, pool2);

            futures.add(stage2);
        }

        // Đợi tất cả hoàn thành và cộng dồn
        for (CompletableFuture<Long> f : futures) {
            try {
                finalTotal.addAndGet(f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total = " + finalTotal.get());

        // Đóng các pool
        pool1.shutdown();
        pool2.shutdown();
        sc.close();
    }
}