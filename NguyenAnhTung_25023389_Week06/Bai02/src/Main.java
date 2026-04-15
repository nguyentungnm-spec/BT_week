public class Main {
    public static void main(String[] args) {
        // Giả sử người dùng muốn dùng Email
        NotificationApp myApp = new EmailApp();
        myApp.notifyUser("Chào mừng bạn đến với hệ thống!");

        // Thay đổi sang gửi SMS
        NotificationApp smsApp = new SmsApp();
        smsApp.notifyUser("Mã OTP của bạn là 123456.");
    }
}