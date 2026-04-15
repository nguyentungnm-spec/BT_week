import java.io.*;
import java.util.Scanner;
public class ReadNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên tệp cần đọc: ");
        String fileName = sc.nextLine();

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Dữ liệu trong tệp " + fileName + ":");

            while (true) {
                try {
                    int number = dis.readInt(); // Đọc từng số nguyên
                    System.out.print(number + " ");
                } catch (EOFException e) {
                    // Khi hết dữ liệu, vòng lặp while(true) sẽ dừng tại đây
                    System.out.println("\n Đã đọc hết dữ liệu ");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy tệp: " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi đọc dữ liệu: " + e.getMessage());
        }
    }
}