// Abstract Class Shape
abstract class Shape {
    protected int x, y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw();
    public abstract void erase();

    // Template method: Định nghĩa sẵn quy trình di chuyển
    public void moveTo(int newX, int newY) {
        erase();              // Bước 1: Xóa hình ở vị trí cũ
        this.x = newX;        // Bước 2: Cập nhật tọa độ
        this.y = newY;
        draw();               // Bước 3: Vẽ hình ở vị trí mới
    }
}

// Lớp Circle kế thừa Shape
class Circle extends Shape {
    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Vẽ hình tròn tại (" + x + ", " + y + ")");
    }

    @Override
    public void erase() {
        System.out.println("Xóa hình tròn tại (" + x + ", " + y + ")");
    }
}

// Lớp Square kế thừa Shape
class Square extends Shape {
    public Square(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Vẽ hình vuông tại (" + x + ", " + y + ")");
    }

    @Override
    public void erase() {
        System.out.println("Xóa hình vuông tại (" + x + ", " + y + ")");
    }
}

// Lớp Main để thực thi
public class Main {
    public static void main(String[] args) {
        // Khởi tạo một hình tròn tại tọa độ (10, 10)
        Shape circle = new Circle(10, 10);

        // Gọi lệnh di chuyển đến (20, 20)
        circle.moveTo(20, 20);
    }
}