// Gửi thêm SMS
class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String msg) {
        super.send(msg); // Gửi các kênh đã có trước đó
        System.out.println("Gửi SMS với nội dung: " + msg);
    }
}