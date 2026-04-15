class EmailNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("Gửi Email với nội dung: " + msg);
    }
}

class SmsNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("Gửi tin nhắn SMS với nội dung: " + msg);
    }
}