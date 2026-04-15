import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ArraySumThreadPool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập dữ liệu
        System.out.print("Nhập số lượng phần tử n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 2. Cấu hình Thread Pool và số đoạn (k)
        int k = 4; // Chia làm 4 đoạn
        ExecutorService executor = Executors.newFixedThreadPool(k);
        List<Future<Integer>> listFuture = new ArrayList<>();

        // Tính kích thước mỗi đoạn
        int chunkSize = (int) Math.ceil((double) n / k);

        // 3. Chia mảng và submit các Callable
        for (int i = 0; i < k; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, n);

            if (start < end) {
                Callable<Integer> task = new SumTask(arr, start, end);
                Future<Integer> future = executor.submit(task);
                listFuture.add(future);
            }
        }

        // 4. Lấy kết quả từ Future và cộng lại
        long totalSum = 0;
        try {
            for (Future<Integer> future : listFuture) {
                totalSum += future.get(); // Đợi kết quả từ thread trả về
            }
            System.out.println("===> Tổng cuối cùng: " + totalSum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 5. Đóng ExecutorService đúng cách
            executor.shutdown();
        }

        sc.close();
    }
}