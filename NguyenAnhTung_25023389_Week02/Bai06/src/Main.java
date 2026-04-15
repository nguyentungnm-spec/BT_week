public class Main {
    public static void main(String[] args) {

        Account acc = new Account("ACC01");

        Transaction t1 = new Transaction("T01", 5000, "2026-03-03");
        Transaction t2 = new Transaction("T02", -2000, "2026-03-03");

        acc.addTransaction(t1);
        acc.addTransaction(t2);

        //  Hacker
        Transaction[] history = acc.getHistory();

        history[0] = null; // cố tình phá

        System.out.println("Balance gốc: " + acc.getBalance());

        // Lấy lại history để kiểm tra
        Transaction[] newHistory = acc.getHistory();
        System.out.println("Transaction đầu còn không? "
                + (newHistory[0] != null));
    }
}