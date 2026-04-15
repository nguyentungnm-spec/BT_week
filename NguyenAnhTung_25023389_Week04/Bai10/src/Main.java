public class Main {
    public static void main(String[] args) {
        // 1. Tạo khu vực riêng biệt cho Sách và DVD
        LibrarySection<Book> bookSection = new LibrarySection<>("Khu vực Sách Văn học");
        LibrarySection<DVD> dvdSection = new LibrarySection<>("Khu vực Đĩa Phim");

        // 2. Thêm dữ liệu giả lập
        bookSection.addItem(new Book("B01", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 150));
        bookSection.addItem(new Book("B02", "Số Đỏ", "Vũ Trọng Phụng", 200));

        dvdSection.addItem(new DVD("D01", "Inception", "Christopher Nolan", 148));
        dvdSection.addItem(new DVD("D02", "The Dark Knight", "Christopher Nolan", 152));

        // 3. Hiển thị danh sách (Kiểm tra tính đa hình)
        bookSection.displayAll();
        dvdSection.displayAll();

        // 4. Thử nghiệm xóa
        bookSection.removeItem("B01");
        bookSection.displayAll();

        /* LƯU Ý: Dòng code dưới đây sẽ bị lỗi biên dịch (Compile-time error)
           vì tính an toàn của Generics:
           bookSection.addItem(new DVD("D03", "Avatar", "James Cameron", 162));
        */
    }
}