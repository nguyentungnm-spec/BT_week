import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 1. Khởi tạo Hàng đợi khách hàng (FIFO)
        Queue<Customer> customerQueue = new LinkedList<>();

        // 2. Khởi tạo Lịch sử tin nhắn (LIFO)
        Stack<Message> messageHistory = new Stack<>();

        System.out.println(" HỆ THỐNG BẮT ĐẦU HOẠT ĐỘNG");

        // --- MÔ PHỎNG QUÁ TRÌNH ---

        // Bước 1: Khách A và Khách B đến
        customerQueue.offer(new Customer(1, "Nguyễn Văn A"));
        customerQueue.offer(new Customer(2, "Trần Thị B"));
        System.out.println("Đã thêm Khách A và Khách B vào hàng đợi.");

        // Bước 2: Xử lý Khách hàng đầu tiên (Khách A)
        processCustomer(customerQueue, messageHistory);

        // Bước 3: Xử lý Khách hàng tiếp theo (Khách B)
        processCustomer(customerQueue, messageHistory);

        // Bước 4: Thử xử lý khi không còn khách
        processCustomer(customerQueue, messageHistory);
    }

    public static void processCustomer(Queue<Customer> queue, Stack<Message> history) {
        // Lấy khách hàng ra khỏi hàng đợi (FIFO)
        Customer currentCustomer = queue.poll();

        if (currentCustomer == null) {
            System.out.println("\n[Thông báo]: Không còn khách đợi.");
            return;
        }

        System.out.println("\n đang xử lý: " + currentCustomer);
        history.clear(); // Xóa lịch sử tin nhắn cũ của khách trước

        // Giả lập gõ 3 dòng tin nhắn
        typeMessage(history, 1, "Chào bạn, tôi là nhân viên hỗ trợ của Tiki.");
        typeMessage(history, 2, "Tôi có thể giúp gì cho bạn?");
        typeMessage(history, 3, "Vui lòng cung cấp mã đơn hàng.");

        // Xem câu vừa gõ (Peek)
        System.out.println("Dòng tin nhắn cuối hiện tại: " + history.peek());

        // Tính năng Undo (Pop)
        if (!history.isEmpty()) {
            System.out.println("-> Thực hiện UNDO dòng: " + history.pop());
        }

        System.out.println("Hoàn tất xử lý cho " + currentCustomer.name);
        System.out.println("Lịch sử tin nhắn còn lại: " + history);
    }

    public static void typeMessage(Stack<Message> history, int id, String content) {
        Message msg = new Message(id, content);
        history.push(msg);
        System.out.println("Đã gõ: " + content);
    }
}