public class Main {
    public static void main(String[] args) {

        MyDate d1 = new MyDate(1,1,2000);

        Employee emp1 = new Employee("An", d1);

        // sao chép
        Employee emp2 = new Employee(emp1);

        // thay đổi ngày sinh emp1
        emp1.birthday.day = 2;
        emp1.birthday.month = 2;
        emp1.birthday.year = 2022;

        // in ngày sinh emp2
        System.out.println(
                emp2.birthday.day + "/" +
                        emp2.birthday.month + "/" +
                        emp2.birthday.year
        );
    }
}