import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class BookStore {
    private final Map<String, Integer> stock = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public int getStock(String title) {
        lock.readLock().lock();
        try {
            System.out.println("   [READ] " + Thread.currentThread().getName() + " đang xem sách: " + title);
            Thread.sleep(800);
            return stock.getOrDefault(title, 0);
        } catch (InterruptedException e) {
            return 0;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addBook(String title, int qty) {
        lock.writeLock().lock();
        try {
            System.out.println(">>> [WRITE] " + Thread.currentThread().getName() + " đang NHẬP KHO: " + title + " (+" + qty + ")");
            Thread.sleep(1200);
            stock.put(title, stock.getOrDefault(title, 0) + qty);
        } catch (InterruptedException e) {
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void borrow(String title, int qty) {
        lock.writeLock().lock();
        try {
            int current = stock.getOrDefault(title, 0);
            if (current >= qty) {
                System.out.println(">>> [WRITE] " + Thread.currentThread().getName() + " đang CHO MƯỢN: " + title + " (-" + qty + ")");
                Thread.sleep(1200);
                stock.put(title, current - qty);
            } else {
                System.out.println(">>> [WRITE] " + Thread.currentThread().getName() + " thất bại: " + title + " không đủ hàng.");
            }
        } catch (InterruptedException e) {
        } finally {
            lock.writeLock().unlock();
        }
    }
}