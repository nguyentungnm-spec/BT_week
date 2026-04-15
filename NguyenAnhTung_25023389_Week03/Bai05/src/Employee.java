import java.util.Scanner;
// 1. Lớp cha trừu tượng
abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    // Phương thức trừu tượng để các lớp con tự cài đặt logic
    public abstract double calculateSalary();
    public abstract String getType();

    public String getName() {
        return name;
    }
}