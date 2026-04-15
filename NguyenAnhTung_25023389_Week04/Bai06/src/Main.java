import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1. Thử nghiệm với Integer
        Integer[] intArray = {5, 1, 3, 2};
        ArrayUtils.sort(intArray);
        printArray(intArray);

        // 2. Thử nghiệm với String
        String[] strArray = {"Java", "C++", "Python"};
        ArrayUtils.sort(strArray);
        printArray(strArray);

        // 3. Thử nghiệm với Student
        Student[] students = {
                new Student("Minh", 3.5),
                new Student("An", 3.9),
                new Student("Bình", 3.2)
        };
        ArrayUtils.sort(students);
        printArray(students);
    }

    // Hàm phụ trợ in mảng
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}