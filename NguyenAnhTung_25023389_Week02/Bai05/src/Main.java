public class Main {
    public static void main(String[] args) {

        Book b1 = new Book("Java Basic", "Nguyen Van A", 100.0);
        Book b2 = new Book("Java Basic", "Nguyen Van A", 100.0);

        // So sánh bằng ==
        System.out.println("So sánh bằng == : " + (b1 == b2));

        // So sánh bằng equals
        System.out.println("So sánh bằng equals : " + b1.equals(b2));
    }
}