public class Main {
    public static void main(String[] args) throws InterruptedException {
        BookStore store = new BookStore();
        store.addBook("Java Advanced", 10);

        System.out.println("--- BẮT ĐẦU HỆ THỐNG QUẢN LÝ ---");

        // Tạo danh sách các Thread để quản lý
        Thread[] threads = new Thread[5];

        // 3 Luồng đọc (mỗi luồng đọc 3 lần)
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    int q = store.getStock("Java Advanced");
                    System.out.println("      Log: Số lượng hiện tại là " + q);
                    try { Thread.sleep(500); } catch (InterruptedException e) {}
                }
                System.out.println(Thread.currentThread().getName() + " ĐÃ XONG.");
            }, "Reader-" + (i + 1));
        }

        // 2 Luồng ghi (mỗi luồng ghi 2 lần)
        threads[3] = new Thread(() -> {
            for (int j = 0; j < 2; j++) {
                store.addBook("Java Advanced", 5);
                try { Thread.sleep(1500); } catch (InterruptedException e) {}
            }
            System.out.println(Thread.currentThread().getName() + " ĐÃ XONG.");
        }, "Writer-Importer");

        threads[4] = new Thread(() -> {
            for (int j = 0; j < 2; j++) {
                store.borrow("Java Advanced", 3);
                try { Thread.sleep(1500); } catch (InterruptedException e) {}
            }
            System.out.println(Thread.currentThread().getName() + " ĐÃ XONG.");
        }, "Writer-Borrower");

        // Chạy tất cả các luồng
        for (Thread t : threads) t.start();

        // Đợi tất cả các luồng kết thúc (Join)
        for (Thread t : threads) t.join();

        System.out.println("--- TẤT CẢ CÔNG VIỆC HOÀN TẤT. HỆ THỐNG DỪNG. ---");
    }
}