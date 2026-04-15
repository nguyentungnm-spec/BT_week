class InventoryDeep {
    private Product[] items;

    public InventoryDeep(Product[] initialItems) {
        items = new Product[initialItems.length];
        for (int i = 0; i < initialItems.length; i++) {
            items[i] = new Product(initialItems[i]); // Copy từng object
        }
    }

    public void display() {
        for (Product p : items) {
            p.display();
        }
    }
}