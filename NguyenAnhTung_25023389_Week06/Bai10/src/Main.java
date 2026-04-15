public class Main {
    public static void main(String[] args) {
        // Lấy instance ở nơi thứ nhất
        Logger logger1 = Logger.getInstance();

        // Lấy instance ở nơi thứ hai
        Logger logger2 = Logger.getInstance();

        // Kiểm tra xem hai biến có cùng trỏ vào một địa chỉ ô nhớ không
        System.out.println("Logger instances equal: " + (logger1 == logger2));

        // Ghi các log khác nhau
        logger1.logInfo("Application started");
        logger2.logInfo("Processing data...");
        logger1.logError("Something went wrong");

        // Thử nghiệm: Lệnh dưới đây sẽ gây lỗi biên dịch (Compile Error)
        // Logger logger3 = new Logger();
    }
}