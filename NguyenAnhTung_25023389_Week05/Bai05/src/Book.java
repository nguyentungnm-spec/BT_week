public class Book {
    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }

    @Override
    public String toString() {
        return String.format("ID: %s | Title: %-20s | Author: %-15s | Year: %d", id, title, author, year);
    }
}