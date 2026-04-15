class InventoryShallow {
    private Product[] items;

    public InventoryShallow(Product[] initialItems) {
        this.items = initialItems; // GÁN TRỰC TIẾP
    }

    public void display() {
        for (Product p : items) {
            p.display();
        }
    }
}