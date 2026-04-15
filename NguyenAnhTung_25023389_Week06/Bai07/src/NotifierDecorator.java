// Lớp trang trí trừu tượng
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrapper;

    public NotifierDecorator(Notifier notifier) {
        this.wrapper = notifier;
    }

    @Override
    public void send(String msg) {
        wrapper.send(msg); // Chuyển tiếp yêu cầu cho đối tượng bên trong
    }
}