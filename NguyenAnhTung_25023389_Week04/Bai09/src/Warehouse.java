import java.util.ArrayList;
import java.util.List;

public class Warehouse<T extends Product> {
    private String tenKho;
    private List<T> danhSachHang = new ArrayList<>();

    public Warehouse(String tenKho) {
        this.tenKho = tenKho;
    }

    public void nhapKho(T item) {
        danhSachHang.add(item);
        System.out.println("Đã nhập: " + item.getTenHang());
    }

    public void xuatKho(String maHang) {
        danhSachHang.removeIf(item -> item.getMaHang().equals(maHang));
        System.out.println("Đã xuất hàng có mã: " + maHang);
    }

    public void kiemKe() {
        System.out.println("\n--- KIỂM KÊ KHO: " + tenKho.toUpperCase() + " ---");
        for (T item : danhSachHang) {
            // Nhờ tính đa hình, item.toString() sẽ gọi đúng getDetails() tương ứng
            System.out.println(item);
        }
    }
}