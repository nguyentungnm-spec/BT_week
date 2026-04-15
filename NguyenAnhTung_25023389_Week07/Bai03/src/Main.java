public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Luồng A: Gửi tiền 1000 lần, mỗi lần 100
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(100);
            }
        });

        // Luồng B: Rút tiền 1000 lần, mỗi lần 100
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(100);
            }
        });

        // Bắt đầu chạy các luồng
        threadA.start();
        threadB.start();

        try {
            // Đợi cả 2 luồng hoàn thành trước khi in kết quả
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // In số dư cuối cùng
        System.out.println("Final balance: " + account.getBalance());
    }
}