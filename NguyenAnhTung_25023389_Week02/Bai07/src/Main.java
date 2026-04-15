public class Main {
    public static void main(String[] args) {

        Product[] arr = new Product[2];
        arr[0] = new Product("P1", "Laptop", 1000);
        arr[1] = new Product("P2", "Mouse", 50);

        InventoryShallow kho1 = new InventoryShallow(arr);
        InventoryDeep kho2 = new InventoryDeep(arr);

        // Thay đổi giá bên ngoài
        arr[0].setPrice(5000);

        System.out.println("Shallow Copy:");
        kho1.display();

        System.out.println("Deep Copy:");
        kho2.display();
    }
}