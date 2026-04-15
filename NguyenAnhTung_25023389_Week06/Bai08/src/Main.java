public class Main {
    public static void main(String[] args) {
        // Tạo dữ liệu báo cáo
        Report myReport = new Report("Báo cáo tháng 4", "Nội dung bài tập lập trình nâng cao.");

        // 1. Sử dụng JSON Formatter
        ReportService jsonService = new ReportService(new JsonFormatter());
        System.out.println(" Xuất định dạng JSON ");
        System.out.println(jsonService.export(myReport));

        System.out.println();

        // 2. Sử dụng XML Formatter
        ReportService xmlService = new ReportService(new XmlFormatter());
        System.out.println(" Xuất định dạng XML ");
        System.out.println(xmlService.export(myReport));
    }
}