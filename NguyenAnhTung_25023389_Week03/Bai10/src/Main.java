import java.util.ArrayList;
import java.util.Scanner;

// 1. Lớp cha Employee
class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateBonus() {
        return baseSalary * 0.1; // Mặc định 10%
    }

    public String getName() {
        return name;
    }
}

// 2. Lớp Developer kế thừa Employee
class Developer extends Employee {
    private int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateBonus() {
        return (baseSalary * 0.1) + (overtimeHours * 200000);
    }
}

// 3. Lớp Tester kế thừa Employee
class Tester extends Employee {
    private int bugsFound;

    public Tester(String name, double baseSalary, int bugsFound) {
        super(name, baseSalary);
        this.bugsFound = bugsFound;
    }

    @Override
    public double calculateBonus() {
        return (baseSalary * 0.1) + (bugsFound * 50000);
    }
}

// 4. Hàm Main xử lý logic
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();

        System.out.print("Nhập số lượng nhân viên: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equalsIgnoreCase("E")) {
                list.add(new Employee(name, salary));
            } else if (type.equalsIgnoreCase("D")) {
                int ot = sc.nextInt();
                list.add(new Developer(name, salary, ot));
            } else if (type.equalsIgnoreCase("T")) {
                int bugs = sc.nextInt();
                list.add(new Tester(name, salary, bugs));
            }
        }

        System.out.println("\n--- Kết quả tính thưởng ---");
        for (Employee emp : list) {
            System.out.println("\n" + emp.getName() + " - Bonus: " + emp.calculateBonus());

            // Xử lý nâng cao: Kiểm tra kiểu đối tượng
            if (emp instanceof Developer) {
                System.out.println("Tặng khóa học AWS");
            } else if (emp instanceof Tester) {
                System.out.println("Tặng tool Test");
            }
        }

        sc.close();
    }
}