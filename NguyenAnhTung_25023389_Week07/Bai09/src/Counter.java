import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

class Counter {
    private int value = 0;
    private final ReentrantLock lock = new ReentrantLock();

    // Phương thức increment cơ bản sử dụng lock()
    public void increment() {
        lock.lock(); // Bắt đầu bảo vệ
        try {
            value++;
        } finally {
            lock.unlock(); // Luôn giải phóng lock trong khối finally
        }
    }

    // Phương thức increment nâng cao sử dụng tryLock()
    public void incrementWithTryLock(String threadName) {
        try {
            // Thử lấy lock trong vòng 100 miligiây
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    value++;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(threadName + ": Không thể lấy lock, bỏ qua lượt này.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getValue() {
        return value;
    }
}