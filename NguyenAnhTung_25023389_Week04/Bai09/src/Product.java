public abstract class Product {
    private String maHang;
    private String tenHang;

    public Product(String maHang, String tenHang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
    }

    public String getMaHang() { return maHang; }
    public String getTenHang() { return tenHang; }

    // Phương thức trừu tượng để mỗi loại hàng tự quyết định cách in thông tin
    public abstract String getDetails();

    @Override
    public String toString() {
        return "Mã: " + maHang + " | Tên: " + tenHang + " | " + getDetails();
    }
}