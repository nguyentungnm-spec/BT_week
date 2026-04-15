import java.io.*;
import java.util.Scanner;

public class WriteNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên tệp để ghi (với đuôi .dat): ");
        String fileName = sc.nextLine();

        // Sử dụng Try-with-resources để tự động đóng luồng
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            System.out.print("Bạn muốn nhập bao nhiêu số nguyên? n = ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("Nhập số thứ " + (i + 1) + ": ");
                int number = sc.nextInt();
                dos.writeInt(number); // Ghi số nguyên vào file nhị phân
            }
            System.out.println("Ghi dữ liệu thành công vào " + fileName);
        } catch (IOException e) {
            System.err.println("Có lỗi xảy ra khi ghi file: " + e.getMessage());
        }
    }
}