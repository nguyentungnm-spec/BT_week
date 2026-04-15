public class Main {
    public static void main(String[] args) {
        // Tạo 2 thực thể Task với tên và thời gian chờ khác nhau
        Task task1 = new Task("Task A", 2000); // Chạy trong 2 giây
        Task task2 = new Task("Task B", 1000); // Chạy trong 1 giây

        // Bọc Task vào các Thread
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Bắt đầu thực thi song song
        thread1.start();
        thread2.start();

        try {
            // Đợi thread1 và thread2 hoàn thành trước khi chạy tiếp các dòng lệnh bên dưới
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Dòng này chỉ in ra sau khi cả hai thread đã kết thúc nhờ join()
        System.out.println("All tasks done.");
    }
}