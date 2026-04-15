-Sửa lớp Person:
class Person {
    String name;
    String dob;

    public Person(String name) {
        this.name = name;
        System.out.println("Person is created");
    }
}
-Giải thích phần Nâng cao:
1. Quan sát lỗi:
Khi xóa constructor mặc định của Person và thay bằng public Person(String name), các lớp Employee và Manager sẽ báo lỗi biên dịch.

2. Tại sao lại lỗi?

Trong Java, mọi constructor của lớp con đều mặc định gọi super() (constructor không tham số của lớp cha) ở dòng đầu tiên.

Khi bạn định nghĩa một constructor có tham số trong Person, Java sẽ không tự động tạo constructor mặc định nữa.

Do đó, Employee không tìm thấy constructor không tham số ở Person để gọi, dẫn đến lỗi "Implicit super constructor Person() is undefined".
3. Cách sửa lỗi:
class Employee extends Person {
    double salary;

    public Employee() {
        super("Unknown");   // gọi constructor Person
        System.out.println("Employee is created");
    }
}

class Manager extends Employee {
    String department;

    public Manager() {
        super();  // gọi constructor Employee
        System.out.println("Manager is created");
    }
}