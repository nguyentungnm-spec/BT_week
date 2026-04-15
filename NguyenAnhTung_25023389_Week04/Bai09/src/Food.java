// Lớp Thực phẩm
class Food extends Product {
    private String hanSuDung;

    public Food(String maHang, String tenHang, String hanSuDung) {
        super(maHang, tenHang);
        this.hanSuDung = hanSuDung;
    }

    @Override
    public String getDetails() {
        return "Hạn sử dụng: " + hanSuDung;
    }
}