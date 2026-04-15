public class Account {

    private String accountId;
    private double balance;
    private Transaction[] history;
    private int count; // số lượng giao dịch hiện tại

    public Account(String accountId) {
        this.accountId = accountId;
        this.balance = 0;
        this.history = new Transaction[100]; // tối đa 100 giao dịch
        this.count = 0;
    }

    public void addTransaction(Transaction t) {
        if (count < history.length) {
            history[count] = t;
            balance += t.getAmount();
            count++;
        }
    }

    //  Defensive Copy
    public Transaction[] getHistory() {
        Transaction[] copy = new Transaction[count];

        for (int i = 0; i < count; i++) {
            copy[i] = history[i];
            // Không cần tạo Transaction mới vì Transaction đã immutable
        }

        return copy;
    }

    public double getBalance() {
        return balance;
    }
}