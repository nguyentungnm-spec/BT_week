import java.util.Scanner;

public class Product {

    // ===== Instance Fields =====
    private String name;
    private double price;
    private int quantity;
    private double discount;

    // ===== Static Fields =====
    private static double taxRate = 0.1;
    private static double totalRevenue = 0;

    // ===== Constructor =====
    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    // ===== Static Method =====
    public static void updateTaxRate(double newRate) {
        taxRate = newRate;
    }

    // ===== Calculate final price =====
    public double calculateFinalPrice() {
        return (price - discount) * (1 + taxRate);
    }

    // ===== Update discount =====
    public void updateDiscount(double newDiscount) {
        this.discount = newDiscount;
    }

    // ===== Sell method =====
    public void sell(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            double revenue = amount * calculateFinalPrice();
            totalRevenue += revenue;
            System.out.println("Bán thành công " + amount + " sản phẩm " + name);
        } else {
            System.err.println("Không đủ hàng trong kho");
        }
    }

    // ===== Getter cho totalRevenue =====
    public static double getTotalRevenue() {
        return totalRevenue;
    }

    // ===== Main =====
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===== Nhập p1 =====
        System.out.println("Nhập thông tin sản phẩm 1:");
        String name1 = sc.nextLine();
        double price1 = sc.nextDouble();
        int quantity1 = sc.nextInt();
        double discount1 = sc.nextDouble();
        sc.nextLine(); // clear buffer

        Product p1 = new Product(name1, price1, quantity1, discount1);

        // ===== Nhập p2 =====
        System.out.println("Nhập thông tin sản phẩm 2:");
        String name2 = sc.nextLine();
        double price2 = sc.nextDouble();
        int quantity2 = sc.nextInt();
        double discount2 = sc.nextDouble();

        Product p2 = new Product(name2, price2, quantity2, discount2);

        // ===== Thực hiện bán =====
        System.out.println("Nhập số lượng mua của sản phẩm 1:");
        int buy1 = sc.nextInt();
        p1.sell(buy1);

        System.out.println("Nhập số lượng mua của sản phẩm 2:");
        int buy2 = sc.nextInt();
        p2.sell(buy2);

        // ===== In giá sau bán =====
        System.out.println("Giá cuối cùng p1: " + p1.calculateFinalPrice());
        System.out.println("Giá cuối cùng p2: " + p2.calculateFinalPrice());

        // ===== Giảm thuế xuống 8% =====
        Product.updateTaxRate(0.08);

        System.out.println("Sau khi giảm thuế:");
        System.out.println("Giá cuối cùng p1: " + p1.calculateFinalPrice());
        System.out.println("Giá cuối cùng p2: " + p2.calculateFinalPrice());

        // ===== Thay discount p1 =====
        p1.updateDiscount(10.0);

        System.out.println("Sau khi giảm giá riêng p1:");
        System.out.println("Giá cuối cùng p1: " + p1.calculateFinalPrice());
        System.out.println("Giá cuối cùng p2: " + p2.calculateFinalPrice());

        // ===== Tổng doanh thu =====
        System.out.println("Tổng doanh thu toàn hệ thống: " + Product.getTotalRevenue());

        sc.close();
    }
}