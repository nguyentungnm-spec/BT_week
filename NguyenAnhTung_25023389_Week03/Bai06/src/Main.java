import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// --- Lớp Cha ---
abstract class Product {
    protected String name;
    protected double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public abstract double getFinalPrice();
    public abstract String getCategory();

    @Override
    public String toString() {
        return String.format("%s - %s - %.1f", name, getCategory(), getFinalPrice());
    }
}

// --- Lớp Điện tử ---
class Electronics extends Product {
    private double warrantyFee;

    public Electronics(String name, double basePrice, double warrantyFee) {
        super(name, basePrice);
        this.warrantyFee = warrantyFee;
    }

    @Override
    public double getFinalPrice() {
        // Thuế VAT 10% + Phí bảo hành
        return (basePrice * 1.1) + warrantyFee;
    }

    @Override
    public String getCategory() { return "Electronics"; }
}

// --- Lớp Thực phẩm ---
class Food extends Product {
    private LocalDate expiryDate;

    public Food(String name, double basePrice, String expiryDateStr) {
        super(name, basePrice);
        this.expiryDate = LocalDate.parse(expiryDateStr);
    }

    @Override
    public double getFinalPrice() {
        long daysRemaining = ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
        // Nếu còn ít hơn 7 ngày (bao gồm cả đã quá hạn), giảm 20%
        if (daysRemaining < 7) {
            return basePrice * 0.8;
        }
        return basePrice;
    }

    @Override
    public String getCategory() { return "Food"; }
}

// --- Chương trình chính ---
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> order = new ArrayList<>();

        System.out.print("Nhập số lượng sản phẩm: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            String name = parts[1].replace("\"", ""); // Bỏ dấu ngoặc kép
            double price = Double.parseDouble(parts[2]);

            if (type.equals("E")) {
                double warranty = Double.parseDouble(parts[3]);
                order.add(new Electronics(name, price, warranty));
            } else if (type.equals("F")) {
                String date = parts[3];
                order.add(new Food(name, price, date));
            }
        }

        System.out.println("\n--- Hóa đơn ---");
        double total = 0;
        for (Product p : order) {
            System.out.println(p);
            total += p.getFinalPrice();
        }
        System.out.println("Total = " + total);

        sc.close();
    }
}