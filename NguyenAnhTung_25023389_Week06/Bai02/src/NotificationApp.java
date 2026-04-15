abstract class NotificationApp {
    // Factory Method: Để các lớp con quyết định loại đối tượng nào được tạo ra
    public abstract Notification createNotification();

    // Phương thức thực hiện logic nghiệp vụ mà không cần biết loại thông báo cụ thể
    public void notifyUser(String msg) {
        Notification notification = createNotification();
        notification.send(msg);
    }
}