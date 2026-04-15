public class AppConfig {
    // Biến instance duy nhất, sử dụng volatile để đảm bảo các luồng
    // luôn đọc được giá trị mới nhất từ bộ nhớ chính
    private static volatile AppConfig instance;

    // Các thuộc tính cấu hình
    private String appName;
    private String version;
    private String logLevel;

    // Constructor private để ngăn việc khởi tạo từ bên ngoài
    private AppConfig() {
        this.appName = "My Awesome App";
        this.version = "1.0.0";
        this.logLevel = "INFO";
    }

    // Phương thức getInstance theo kiểu khởi tạo lười (Lazy Initialization)
    public static AppConfig getInstance() {
        if (instance == null) { // Check 1
            synchronized (AppConfig.class) {
                if (instance == null) { // Check 2
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    // Getter và Setter (Tùy chọn)
    public String getAppName() { return appName; }
    public String getVersion() { return version; }
    public String getLogLevel() { return logLevel; }

    @Override
    public String toString() {
        return "AppConfig [appName=" + appName + ", version=" + version + ", logLevel=" + logLevel + "]";
    }
}