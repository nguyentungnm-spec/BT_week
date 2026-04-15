import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// 1. Interface IPayable
interface IPayable {
    double getPaymentAmount();
}

// 2. Lớp trừu tượng Staff thực thi IPayable
abstract class Staff implements IPayable {
    protected String id;
    protected String name;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter và Setter
    public String getId() { return id; }
    public String getName() { return name; }
}

// 3. Lớp PartTimeStaff kế thừa Staff
class PartTimeStaff extends Staff {
    private int workingHours;
    private double hourlyRate;

    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPaymentAmount() {
        return workingHours * hourlyRate;
    }

    @Override
    public String toString() {
        return "PartTimeStaff " + name + " - Payment: " + getPaymentAmount();
    }
}

// 4. Lớp Invoice thực thi IPayable
class Invoice implements IPayable {
    private String itemName;
    private int quantity;
    private double pricePerItem;

    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return "Invoice " + itemName + " - Payment: " + getPaymentAmount();
    }
}

// 5. Hàm main điều khiển chương trình
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<IPayable> payableList = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equalsIgnoreCase("S")) {
                String id = sc.next();
                String name = sc.next();
                int hours = sc.nextInt();
                double rate = sc.nextDouble();
                payableList.add(new PartTimeStaff(id, name, hours, rate));
            } else if (type.equalsIgnoreCase("I")) {
                String itemName = sc.next();
                int quantity = sc.nextInt();
                double price = sc.nextDouble();
                payableList.add(new Invoice(itemName, quantity, price));
            }
        }

        double totalPayment = 0;
        for (IPayable item : payableList) {
            System.out.println(item.toString());
            totalPayment += item.getPaymentAmount();
        }

        System.out.println("Total Payment = " + totalPayment);
        sc.close();
    }
}