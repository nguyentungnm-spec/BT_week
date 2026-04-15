public class BankAccount {

    // Fields
    private final String accountNumber; // chỉ đọc
    private double balance;             // không truy cập trực tiếp
    private String ownerName;

    // Constructor 1: mặc định balance = 0
    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    // Constructor 2: nhận đủ 3 tham số
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        if (balance < 0) {
            System.out.println("So du khong hop le. Dat ve 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    // Nạp tiền
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien nap phai > 0");
            return;
        }
        balance += amount;
        System.out.println("Nap tien thanh cong: " + amount);
    }

    // Rút tiền
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien rut phai > 0");
            return false;
        }

        if (amount > balance) {
            System.out.println("Khong du so du de rut");
            return false;
        }

        balance -= amount;
        System.out.println("Rut tien thanh cong: " + amount);
        return true;
    }

    // Chỉ xem số dư
    public double getBalance() {
        return balance;
    }

    // Main test
    public static void main(String[] args) {

        BankAccount acc = new BankAccount("123456", "Nguyen Van A");

        // Nạp tiền âm
        acc.deposit(-100);

        // Nạp hợp lệ
        acc.deposit(500);

        // Rút quá số dư
        acc.withdraw(1000);

        // Rút tiền hợp lệ
        acc.withdraw(200);

        // Xem số dư cuối
        System.out.println("So du hien tai: " + acc.getBalance());

        // Test constructor balance âm
        BankAccount acc2 = new BankAccount("999999", "Tran Van B", -50);
        System.out.println("So du tai khoan 2: " + acc2.getBalance());
    }
}