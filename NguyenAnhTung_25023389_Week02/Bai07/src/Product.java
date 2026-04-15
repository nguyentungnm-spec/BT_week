class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Copy constructor (sẽ dùng cho Deep Copy)
    public Product(Product other) {
        this.id = other.id;
        this.name = other.name;
        this.price = other.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {
        System.out.println(id + " - " + name + " - $" + price);
    }
}