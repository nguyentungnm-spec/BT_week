import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class OrderProcessor implements Callable<Boolean> {
    private String id;
    private long processMs;
    private List<String> logs;
    private AtomicInteger successCounter;

    public OrderProcessor(String id, long processMs, List<String> logs, AtomicInteger successCounter) {
        this.id = id;
        this.processMs = processMs;
        this.logs = logs;
        this.successCounter = successCounter;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("Start " + id);

        // Mô phỏng thời gian xử lý
        Thread.sleep(processMs);

        boolean isSuccess = processMs <= 1500;
        String status = isSuccess ? "DONE " : "FAIL ";

        // Đồng bộ hóa khi ghi vào danh sách dùng chung
        synchronized (logs) {
            logs.add(status + id);
        }

        if (isSuccess) {
            successCounter.incrementAndGet();
        }

        return isSuccess;
    }
}