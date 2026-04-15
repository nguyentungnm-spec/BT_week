public class Main {
    public static void main(String[] args) {
        // 1. Kho thực phẩm (Chỉ nhận Food)
        Warehouse<Food> khoThucPham = new Warehouse<>("Kho Lạnh A");
        khoThucPham.nhapKho(new Food("F01", "Sữa tươi", "20/12/2026"));
        khoThucPham.nhapKho(new Food("F02", "Thịt bò", "15/04/2026"));

        // 2. Kho điện tử (Chỉ nhận Electronic)
        Warehouse<Electronic> khoDienTu = new Warehouse<>("Kho Đồ Gia Dụng");
        khoDienTu.nhapKho(new Electronic("E01", "Tivi Sony", 24));
        khoDienTu.nhapKho(new Electronic("E02", "Tủ lạnh LG", 12));

        // 3. Kiểm kê
        khoThucPham.kiemKe();
        khoDienTu.kiemKe();

        // LƯU Ý: Dòng dưới đây sẽ báo lỗi biên dịch vì vi phạm Bounded Type
        // Warehouse<String> khoLoi = new Warehouse<>("Lỗi"); // Lỗi! String không kế thừa Product
        // khoThucPham.nhapKho(new Electronic("E03", "Máy giặt", 12)); // Lỗi! Kho thực phẩm không nhận đồ điện tử
    }
}