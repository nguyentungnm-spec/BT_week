import java.util.ArrayList;
import java.util.Scanner;

// 1. Interface (Không để public)
interface IWorkable {
    void work();
}

// 2. Abstract Class (Không để public)
abstract class Employee implements IWorkable {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculatePay();
}

// 3. Class OfficeWorker
class OfficeWorker extends Employee {
    public OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    @Override
    public double calculatePay() {
        return baseSalary;
    }

    @Override
    public void work() {
        System.out.println("Soạn thảo văn bản");
    }
}

// 4. Class Technician
class Technician extends Employee {
    private int overtimeHours;

    public Technician(String id, String name, double baseSalary, int overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculatePay() {
        return baseSalary + overtimeHours * 20000;
    }

    @Override
    public void work() {
        System.out.println("Lắp đặt thiết bị");
    }
}

// 5. Class Main (Để public và chứa hàm chạy chương trình)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        // Kiểm tra xem có dữ liệu nhập vào không
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double baseSalary = sc.nextDouble();

            if (type.equalsIgnoreCase("O")) {
                employees.add(new OfficeWorker(id, name, baseSalary));
            } else if (type.equalsIgnoreCase("T")) {
                int ot = sc.nextInt();
                employees.add(new Technician(id, name, baseSalary, ot));
            }
        }

        double totalPay = 0;
        for (Employee emp : employees) {
            double pay = emp.calculatePay();
            totalPay += pay;

            System.out.println(emp.name + " - Pay: " + pay);
            emp.work();
            System.out.println(); // Dòng trống ngăn cách giữa các nhân viên
        }

        System.out.println("Total Pay = " + totalPay);
        sc.close();
    }
}