public class Main {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread thread = new Thread(worker);

        // Bắt đầu chạy luồng
        thread.start();

        // Cho luồng chạy khoảng 1 giây
        Thread.sleep(1000);

        // Yêu cầu dừng luồng
        System.out.println("Stopping worker...");
        worker.stop();

        // Đợi luồng kết thúc hoàn toàn
        thread.join();

        System.out.println("Main thread finished.");
    }
}
//Tại sao cần volatile?
//
//Tính hiển thị (Visibility): Nếu không có volatile, khi luồng main thay đổi running = false, luồng Worker có thể vẫn đang đọc giá trị true từ bộ nhớ đệm của nó và tiếp tục vòng lặp vô tận.
//
//Cập nhật tức thì: Từ khóa volatile đảm bảo rằng mọi thao tác đọc/ghi biến này đều được thực hiện trực tiếp trên bộ nhớ chính. Khi luồng main thay đổi giá trị, luồng Worker sẽ nhìn thấy sự thay đổi đó ngay lập tức.