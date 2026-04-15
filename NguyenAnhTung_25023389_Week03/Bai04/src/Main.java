public class Main {
    public static void main(String[] args) {
        Animal a = new Dog(); // Khởi tạo một con Chó trong lốt Động vật

        // --- PHẦN 1: TRƯỚC KHI SỬA (Gây ra lỗi) ---
        System.out.println("Trước khi sửa:");
        try {
            // Ép kiểu sai trái: Ép Dog thành Cat
            Cat c = (Cat) a;
            c.makeSound();
        } catch (ClassCastException e) {
            // Bắt lỗi và in ra tên lỗi như yêu cầu
            System.out.println("Exception: " + e.toString());
        }

        System.out.println("\n--------------------------\n");

        // --- PHẦN 2: SAU KHI SỬA (Dùng instanceof) ---
        System.out.println("Sau khi sửa:");
        if (a instanceof Cat) {
            Cat c = (Cat) a;
            c.makeSound();
        } else {
            System.out.println("Đây không phải là Mèo!");
        }
    }
}