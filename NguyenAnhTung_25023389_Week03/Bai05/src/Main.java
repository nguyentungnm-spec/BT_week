// 4. Lớp điều hành hệ thống
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");

            // Xử lý tách loại NV và Tên (Dựa trên định dạng: F "Tên" ...)
            String typeCode = parts[0].trim();
            String name = parts[1];
            String[] stats = parts[2].trim().split("\\s+");

            if (typeCode.equalsIgnoreCase("F")) {
                double base = Double.parseDouble(stats[0]);
                double bonus = Double.parseDouble(stats[1]);
                double penalty = Double.parseDouble(stats[2]);
                employees[i] = new FullTimeEmployee(name, base, bonus, penalty);
            } else if (typeCode.equalsIgnoreCase("P")) {
                int hours = Integer.parseInt(stats[0]);
                double rate = Double.parseDouble(stats[1]);
                employees[i] = new PartTimeEmployee(name, hours, rate);
            }
        }

        System.out.println("\n--- BẢNG LƯƠNG CHI TIẾT ---");
        for (Employee emp : employees) {
            System.out.printf("%s - %s - %.1f\n",
                    emp.getName(), emp.getType(), emp.calculateSalary());
        }

        sc.close();
    }
}