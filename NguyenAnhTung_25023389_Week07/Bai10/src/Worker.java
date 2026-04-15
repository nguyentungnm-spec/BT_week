class Worker implements Runnable {
    // Sử dụng volatile để đảm bảo thay đổi của biến được cập nhật ngay lập tức
    // giữa các luồng khác nhau (từ luồng main sang luồng Worker)
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Working...");
            try {
                // Nghỉ một chút để tránh làm tràn màn hình console
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Worker stopped.");
    }
}