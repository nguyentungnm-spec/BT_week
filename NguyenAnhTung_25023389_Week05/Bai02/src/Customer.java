// Lớp đại diện cho Khách hàng
class Customer {
    int id;
    String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Khách hàng [ID=" + id + ", Tên=" + name + "]";
    }
}