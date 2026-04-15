public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int numberOfThreads = 4;
        int incrementsPerThread = 10000;
        Thread[] threads = new Thread[numberOfThreads];

        // Tạo và chạy 4 luồng
        for (int i = 0; i < numberOfThreads; i++) {
            final String threadName = "Thread-" + i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                    // Hoặc dùng counter.incrementWithTryLock(threadName);
                }
            });
            threads[i].start();
        }

        // Dùng join() để đợi tất cả hoàn thành
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // In giá trị cuối cùng
        System.out.println("Giá trị cuối cùng của Counter: " + counter.getValue());
        System.out.println("Giá trị kỳ vọng: " + (numberOfThreads * incrementsPerThread));
    }
}