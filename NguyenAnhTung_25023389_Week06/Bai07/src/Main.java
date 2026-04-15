public class Main {
    public static void main(String[] args) {
        System.out.println(" Khởi tạo hệ thống thông báo đa kênh ");

        // 1. Bắt đầu với Email mặc định
        Notifier myNotifier = new EmailNotifier();

        // 2. Bọc thêm tính năng Facebook
        myNotifier = new FacebookNotifier(myNotifier);

        // 3. Bọc thêm tính năng SMS
        myNotifier = new SMSNotifier(myNotifier);

        // Gọi lệnh send một lần duy nhất
        System.out.println("Thực hiện gửi thông báo:");
        myNotifier.send("Chào mừng bạn đến với hệ thống!");
    }
}