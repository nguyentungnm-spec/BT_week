import java.util.*;
import java.util.concurrent.*;

public class Main {

    // Callable để xử lý tìm số lớn thứ hai trong một mảng
    static class SecondLargestTask implements Callable<Integer> {
        private final int[] array;
        private final int index;

        public SecondLargestTask(int index, int[] array) {
            this.index = index;
            this.array = array;
        }

        @Override
        public Integer call() {
            if (array == null || array.length < 2) {
                return null;
            }

            Integer first = null;
            Integer second = null;

            for (int num : array) {
                if (first == null || num > first) {
                    second = first;
                    first = num;
                } else if (num < first && (second == null || num > second)) {
                    second = num;
                }
            }
            return second; // Trả về null nếu không tìm thấy số lớn thứ hai (ví dụ: mảng [5, 5, 5])
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng mảng (n): ");
        int n = sc.nextInt();

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Integer>> futures = new ArrayList<>();

        // Nhập dữ liệu và gửi task vào ExecutorService
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            futures.add(executor.submit(new SecondLargestTask(i, arr)));
        }

        long totalSum = 0;
        System.out.println("\nKết quả:");

        // Lấy kết quả từ Future
        for (int i = 0; i < n; i++) {
            try {
                Integer result = futures.get(i).get();
                if (result != null) {
                    System.out.println("Array " + i + ": second largest = " + result);
                    totalSum += result;
                } else {
                    System.out.println("Array " + i + ": Not found");
                }
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Array " + i + ": Error processing");
            }
        }

        System.out.println("---");
        System.out.println("Sum = " + totalSum);

        executor.shutdown();
    }
}