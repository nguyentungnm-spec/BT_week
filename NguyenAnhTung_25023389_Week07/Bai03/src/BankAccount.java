class BankAccount {
    private int balance = 0;

    // Phương thức gửi tiền an toàn luồng
    public synchronized void deposit(int amount) {
        balance += amount;
    }

    // Phương thức rút tiền an toàn luồng
    public synchronized void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}

