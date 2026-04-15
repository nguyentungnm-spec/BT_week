public class Logger {
    // 1. Thuộc tính static lưu trữ instance duy nhất
    private static Logger instance;

    // 2. Constructor private để chặn khởi tạo từ bên ngoài
    private Logger() {
        // Có thể khởi tạo file log hoặc cấu hình ở đây nếu cần
    }

    // 3. Phương thức public static để truy cập instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Phương thức ghi log thông tin
    public void logInfo(String msg) {
        System.out.println("[INFO] " + msg);
    }

    // Phương thức ghi log lỗi
    public void logError(String msg) {
        System.out.println("[ERROR] " + msg);
    }
}