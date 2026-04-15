public class Student {

    //  Thuộc tính (Encapsulation)
    private String id;
    private String name;
    private String email;
    private double gpa;

    // Constructor 1: Không tham số
    public Student() {
        this.id = "";
        this.name = "";
        this.email = "";
        this.gpa = 0.0;
    }

    // Constructor 2: Có id và name
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.email = "";
        this.gpa = 0.0;
    }

    // Constructor 3: Đầy đủ tham số
    public Student(String id, String name, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        setGpa(gpa); // dùng setter để kiểm tra hợp lệ
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getGpa() {
        return gpa;
    }

    //  Setter (Validation)
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGpa(double gpa) {
        // kiểm tra GPA hợp lệ
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Lỗi: GPA phải nằm trong khoảng 0.0 - 4.0");
        }
    }

    // Hàm hiển thị thông tin
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("GPA: " + gpa);
        System.out.println("----------------------");
    }

    // Hàm main để test
    public static void main(String[] args) {

        // Cách 1: constructor không tham số
        Student s1 = new Student();
        s1.setId("SV01");
        s1.setName("An");
        s1.setEmail("an@gmail.com");
        s1.setGpa(3.2);

        // Cách 2: constructor (id, name)
        Student s2 = new Student("SV02", "Binh");
        s2.setEmail("binh@gmail.com");
        s2.setGpa(3.8);

        // Cách 3: constructor đầy đủ
        Student s3 = new Student("SV03", "Cuong", "cuong@gmail.com", 3.5);

        // Thử gán GPA sai (<0)
        s3.setGpa(-1);

        // In thông tin
        s1.display();
        s2.display();
        s3.display();
    }
}