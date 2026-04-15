class Student implements Comparable<Student> {
    String name;
    double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student other) {
        // Sắp xếp theo tên theo thứ tự bảng chữ cái
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + gpa + ")";
    }
}