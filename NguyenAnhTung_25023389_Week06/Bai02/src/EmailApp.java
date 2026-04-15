class EmailApp extends NotificationApp {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SmsApp extends NotificationApp {
    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}