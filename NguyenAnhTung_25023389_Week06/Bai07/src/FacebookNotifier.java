// Gửi thêm Facebook
class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        super.send(msg); // Gửi các kênh đã có trước đó
        System.out.println("Gửi Facebook với nội dung: " + msg);
    }
}