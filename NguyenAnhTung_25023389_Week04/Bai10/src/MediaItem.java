abstract class MediaItem {
    private String id;
    private String title;

    public MediaItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() { return title; }
    public String getId() { return id; }

    // Phương thức trừu tượng để đa hình xử lý hiển thị
    public abstract void displayInfo();
}