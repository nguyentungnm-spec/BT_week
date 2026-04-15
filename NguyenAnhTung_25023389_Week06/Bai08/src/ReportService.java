class ReportService {
    private ReportFormatter formatter;

    // Tiêm phụ thuộc (Dependency Injection) qua constructor
    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public String export(Report data) {
        return formatter.format(data);
    }
}