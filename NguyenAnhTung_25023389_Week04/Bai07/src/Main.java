import java.util.*;

// Định nghĩa Functional Interface cho các phép toán
@FunctionalInterface
interface Operation<T> {
    T execute(T a, T b);
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        // 1. Nhập liệu
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double gpa = sc.nextDouble();
            students.add(new Student(id, name, gpa));
        }

        // 2. Filter: Xóa sinh viên có GPA < 5.0
        students.removeIf(student -> student.getGpa() < 5.0);

        System.out.println("\nAfter removing GPA < 5.0:");
        students.forEach(System.out::println);

        // 3. Sort: Sắp xếp theo tên bằng Lambda
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

        System.out.println("\nAfter sorting by name:");
        students.forEach(System.out::println);

        // 4. Custom Functional Interface: Demo các phép toán
        System.out.println("\n--- Demo Operation Interface ---");
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> sub = (a, b) -> a - b;
        Operation<Double> mul = (a, b) -> a * b;
        Operation<Double> div = (a, b) -> b != 0 ? a / b : 0.0;

        double x = 10.0, y = 5.0;
        System.out.println("Add: " + add.execute(x, y));
        System.out.println("Sub: " + sub.execute(x, y));
        System.out.println("Mul: " + mul.execute(x, y));
        System.out.println("Div: " + div.execute(x, y));

        sc.close();
    }
}