class Employee {
    String name;
    MyDate birthday;

    // Constructor bình thường
    Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    // Copy Constructor (Deep Copy)
    Employee(Employee other) {
        this.name = other.name;
        this.birthday = new MyDate(
                other.birthday.day,
                other.birthday.month,
                other.birthday.year
        );
    }
}