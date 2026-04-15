import java.util.ArrayList;
import java.util.List;

class LibrarySection<T extends MediaItem> {
    private String sectionName;
    private List<T> items;

    public LibrarySection(String sectionName) {
        this.sectionName = sectionName;
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println("Đã thêm: " + item.getTitle() + " vào " + sectionName);
    }

    public void removeItem(String id) {
        items.removeIf(item -> item.getId().equals(id));
        System.out.println("Đã xóa tài liệu có ID: " + id + " khỏi " + sectionName);
    }

    public void displayAll() {
        System.out.println("\n--- Danh sách tài liệu tại " + sectionName + " ---");
        if (items.isEmpty()) {
            System.out.println("Khu vực này hiện đang trống.");
        } else {
            for (T item : items) {
                item.displayInfo(); // Tính đa hình thực thi ở đây
            }
        }
    }
}