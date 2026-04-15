Code trước khi sửa lỗi trong hàm main:

public class Main {
    public static void main(String[] args) {

        // Bước 1: Upcasting (An toàn)
        Animal a = new Dog();

        // Bước 2: Downcasting (Rủi ro)
        Cat c = (Cat) a;

        // Bước 3: Gọi hàm
        c.makeSound();
    }
}

Thực hành:
a.Biên dịch chương trình (javac) có lỗi không?

Trả lời: Không có lỗi biên dịch. Trình biên dịch chấp nhận việc ép kiểu giữa các lớp trong cùng cây kế thừa.

b.Chạy chương trình (java) có lỗi không? Ghi lại tên lỗi.

Trả lời: Có lỗi xảy ra lúc thực thi.

Tên Exception: java.lang.ClassCastException: Dog cannot be cast to Cat.

Sửa lỗi:
public class Main {
    public static void main(String[] args) {

        Animal a = new Dog();

        if (a instanceof Cat) {
            Cat c = (Cat) a;
            c.makeSound();
        } else {
            System.out.println("Đây không phải là Mèo!");
        }

    }
}