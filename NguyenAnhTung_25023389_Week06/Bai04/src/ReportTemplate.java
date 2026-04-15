import java.util.ArrayList;
import java.util.List;

// Lớp Prototype
class ReportTemplate implements Cloneable {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = sections;
    }

    // Getter và Setter
    public void setTitle(String title) { this.title = title; }

    // Phương thức sao chép (Deep Copy)
    @Override
    public ReportTemplate clone() {
        try {
            ReportTemplate cloned = (ReportTemplate) super.clone();
            // Deep copy cho danh sách sections để tránh dùng chung tham chiếu
            cloned.sections = new ArrayList<>(this.sections);
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Report [Title=" + title + ", Footer=" + footer + ", Sections=" + sections + "]";
    }
}