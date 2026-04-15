public class Main {
    public static void main(String[] args) {
        // Tạo luồng thứ nhất
        Thread thread1 = new Thread(() -> {
            AppConfig config1 = AppConfig.getInstance();
            System.out.println("Thread 1 - HashCode: " + config1.hashCode());
        });

        // Tạo luồng thứ hai
        Thread thread2 = new Thread(() -> {
            AppConfig config2 = AppConfig.getInstance();
            System.out.println("Thread 2 - HashCode: " + config2.hashCode());
        });

        // Chạy cả hai luồng
        thread1.start();
        thread2.start();
    }
}