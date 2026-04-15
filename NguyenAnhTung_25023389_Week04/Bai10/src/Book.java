class Book extends MediaItem {
    private String author;
    private int pages;

    public Book(String id, String title, String author, int pages) {
        super(id, title);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public void displayInfo() {
        System.out.println("Sách: " + getTitle() + " - Tác giả: " + author + " - Số trang: " + pages);
    }
}