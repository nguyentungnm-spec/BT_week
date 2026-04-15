public class Book {
    private String title;
    private String author;
    private double price;

    // Constructor đủ tham số
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Override equals
    @Override
    public boolean equals(Object obj) {
        // Nếu cùng địa chỉ bộ nhớ
        if (this == obj) {
            return true;
        }

        // Nếu obj null hoặc khác lớp
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Ép kiểu về Book
        Book other = (Book) obj;

        // So sánh từng thuộc tính
        return this.title.equals(other.title)
                && this.author.equals(other.author)
                && this.price == other.price;
    }
}