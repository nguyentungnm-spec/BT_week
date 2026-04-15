import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng đơn hàng m: ");
        int m = sc.nextInt();

        // Khởi tạo các công cụ hỗ trợ
        ExecutorService executor = Executors.newFixedThreadPool(3); // Giả sử dùng 3 threads
        List<String> logs = new ArrayList<>();
        AtomicInteger successCount = new AtomicInteger(0);
        List<Future<Boolean>> futures = new ArrayList<>();

        // Nhập dữ liệu và submit task
        for (int i = 0; i < m; i++) {
            System.out.println("Đơn hàng " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = sc.next();
            System.out.print("Thời gian xử lý (ms): ");
            long time = sc.nextLong();

            OrderProcessor task = new OrderProcessor(id, time, logs, successCount);
            futures.add(executor.submit(task));
        }

        // Chờ tất cả các task hoàn thành bằng Future.get()
        for (Future<Boolean> f : futures) {
            try {
                f.get(); // Chặn luồng chính cho đến khi task này xong
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // In kết quả cuối cùng
        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Success = " + successCount.get());
        System.out.println("Danh sách logs (theo thứ tự hoàn thành):");
        for (String log : logs) {
            System.out.println(log);
        }

        // Đóng ExecutorService
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        sc.close();
    }
}