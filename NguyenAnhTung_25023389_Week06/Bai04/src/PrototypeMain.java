import java.util.ArrayList;
import java.util.List;
// Lớp chạy chương trình
public class PrototypeMain {
    public static void main(String[] args) {
        // 1. Tạo template gốc
        List<String> sections = new ArrayList<>();
        sections.add("Nội dung mở đầu");
        ReportTemplate original = new ReportTemplate("Báo cáo gốc", "Trang 1", sections);

        // 2. Tạo bản sao 1 và chỉnh sửa
        ReportTemplate copy1 = original.clone();
        copy1.setTitle("Báo cáo Doanh số tháng 4");

        // 3. Tạo bản sao 2 và chỉnh sửa
        ReportTemplate copy2 = original.clone();
        copy2.setTitle("Báo cáo Nhân sự quý 1");

        // 4. In kết quả kiểm tra
        System.out.println("Gốc: " + original);
        System.out.println("Bản sao 1: " + copy1);
        System.out.println("Bản sao 2: " + copy2);
    }
}