import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter config file path: ");
        String filePath = scanner.nextLine();

        Map<String, String> configMap = new HashMap<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                // Bỏ qua dòng trống hoặc không chứa dấu '='
                if (line.trim().isEmpty() || !line.contains("=")) continue;

                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    configMap.put(parts[0].trim(), parts[1].trim());
                }
            }

            // Kiểm tra dữ liệu (Validation)
            validateConfig(configMap);

            // Nếu không có lỗi, in cấu hình
            System.out.println("Config details: " + configMap);
            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            System.err.println("Config file not found.");
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.err.println("Invalid config: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error.");
            e.printStackTrace();
        } finally {
            // Đóng file
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Program finished.");
            scanner.close();
        }
    }

    private static void validateConfig(Map<String, String> config) throws InvalidConfigException {
        // 1. Kiểm tra bắt buộc có username
        if (!config.containsKey("username") || config.get("username").isEmpty()) {
            throw new InvalidConfigException("Missing username");
        }

        // 2. Kiểm tra bắt buộc có timeout và phải là số > 0
        if (!config.containsKey("timeout")) {
            throw new InvalidConfigException("Missing timeout");
        }
        try {
            int timeout = Integer.parseInt(config.get("timeout"));
            if (timeout <= 0) {
                throw new InvalidConfigException("timeout must be > 0");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException(); // Ném ra để catch ở main
        }

        // 3. Nếu có maxConnections, phải là số >= 1
        if (config.containsKey("maxConnections")) {
            try {
                int maxConn = Integer.parseInt(config.get("maxConnections"));
                if (maxConn < 1) {
                    throw new InvalidConfigException("maxConnections must be >= 1");
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
    }
}