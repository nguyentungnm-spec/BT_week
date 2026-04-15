import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập đường dẫn từ bàn phím
        System.out.print("Nhập đường dẫn tệp nguồn: ");
        String sourcePath = scanner.nextLine();
        System.out.print("Nhập đường dẫn tệp đích: ");
        String destPath = scanner.nextLine();

        // Khai báo các đối tượng luồng bên ngoài khối try để có thể truy cập trong finally
        BufferedReader reader = null;
        PrintWriter writer = null;
        int lineCount = 0;

        try {
            // Khởi tạo luồng đọc
            try {
                reader = new BufferedReader(new FileReader(sourcePath));
            } catch (FileNotFoundException e) {
                System.err.println("Source file not found.");
                return; // Kết thúc chương trình nếu không tìm thấy file nguồn
            }

            // Khởi tạo luồng ghi
            try {
                writer = new PrintWriter(new FileWriter(destPath));
            } catch (FileNotFoundException e) {
                System.err.println("Cannot create destination file.");
                return;
            }

            // Thực hiện sao chép từng dòng
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                lineCount++;
            }

            System.out.println("Sao chép thành công! Tổng số dòng đã chép: " + lineCount);

        } catch (IOException e) {
            // Xử lý lỗi I/O chung
            System.err.println("I/O error.");
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng tệp dù có lỗi hay không
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
                scanner.close();
            } catch (IOException e) {
                System.err.println("Lỗi khi đóng tệp.");
                e.printStackTrace();
            }
        }
    }
}