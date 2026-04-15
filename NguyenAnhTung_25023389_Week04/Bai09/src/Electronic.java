// Lớp Đồ điện tử
class Electronic extends Product {
    private int baoHanh; // số tháng

    public Electronic(String maHang, String tenHang, int baoHanh) {
        super(maHang, tenHang);
        this.baoHanh = baoHanh;
    }

    @Override
    public String getDetails() {
        return "Bảo hành: " + baoHanh + " tháng";
    }
}