public class Main {

    // Hàm swap theo yêu cầu đề bài
    public static void swap(NumberWrapper a, NumberWrapper b) {
        NumberWrapper temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {

        NumberWrapper n1 = new NumberWrapper(5);
        NumberWrapper n2 = new NumberWrapper(10);

        System.out.println("Trước swap:");
        System.out.println("n1 = " + n1.getValue());
        System.out.println("n2 = " + n2.getValue());

        swap(n1, n2);

        System.out.println("Sau swap:");
        System.out.println("n1 = " + n1.getValue());
        System.out.println("n2 = " + n2.getValue());
    }
}