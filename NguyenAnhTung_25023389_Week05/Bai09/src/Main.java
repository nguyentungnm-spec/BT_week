import java.io.*;
import java.util.*;

public class Main {
    private static final String FILE_NAME = "sinhvien.dat";

    public static void main(String[] args) {
        List<Student> listInput = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // --- BƯỚC 1: NHẬP DANH SÁCH ---
        System.out.println("Nhập danh sách sinh viên (Nhập 'END' tại mã SV để dừng):");
        while (true) {
            System.out.print("Mã sinh viên: ");
            String id = sc.nextLine();
            if (id.equalsIgnoreCase("END")) break;

            System.out.print("Họ tên: ");
            String name = sc.nextLine();

            System.out.print("Điểm GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            listInput.add(new Student(id, name, gpa));
        }

        // --- BƯỚC 2: GHI VÀO TỆP (ObjectOutputStream) ---
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(listInput);
            System.out.println("\nĐã ghi danh sách vào tệp thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi tệp: " + e.getMessage());
        }

        // --- BƯỚC 3: ĐỌC TỪ TỆP VÀ IN DANH SÁCH (ObjectInputStream) ---
        System.out.println("\n DANH SÁCH SINH VIÊN ĐỌC TỪ TỆP ");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            @SuppressWarnings("unchecked")
            List<Student> listOutput = (List<Student>) ois.readObject();

            for (Student s : listOutput) {
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy tệp " + FILE_NAME);
        } catch (EOFException e) {
            System.err.println("Lỗi: Kết thúc tệp đột ngột.");
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy lớp Student.");
        } catch (IOException e) {
            System.err.println("Lỗi vào/ra: " + e.getMessage());
        }
    }
}