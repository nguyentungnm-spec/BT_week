import java.util.ArrayList;
import java.util.Scanner;
// 1. Abstract Class Robot
abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
        this.batteryLevel = 50; // Mặc định 50%
    }

    public void chargeBattery() {
        this.batteryLevel = 100;
        System.out.println(modelName + " is fully charged.");
    }

    // Final method: Không cho phép override
    public final void showIdentity() {
        System.out.println("ID: " + id + " | Model: " + modelName);
    }

    public String getModelName() {
        return modelName;
    }

    // Abstract method: Bắt buộc lớp con phải định nghĩa
    public abstract void performMainTask();
}

// 2. Định nghĩa các Interfaces
interface Flyable { void fly(); }
interface Swimmable { void swim(); }
interface GPS { void getCoordinates(); }
interface ElectronicDevice { void turnOn(); }
// DroneRobot: Bay và định vị
class DroneRobot extends Robot implements Flyable, GPS, ElectronicDevice {
    public DroneRobot(int id, String modelName) { super(id, modelName); }

    @Override
    public void performMainTask() { System.out.println(getModelName() + " performing main task"); }

    @Override
    public void fly() { System.out.println(getModelName() + " flying"); }

    @Override
    public void getCoordinates() { System.out.println(getModelName() + " getting coordinates"); }

    @Override
    public void turnOn() { System.out.println(getModelName() + " is turning on..."); }
}

// FishRobot: Bơi
class FishRobot extends Robot implements Swimmable {
    public FishRobot(int id, String modelName) { super(id, modelName); }

    @Override
    public void performMainTask() { System.out.println(getModelName() + " performing main task"); }

    @Override
    public void swim() { System.out.println(getModelName() + " swimming"); }
}

// AmphibiousRobot: Đa năng (Bay, Bơi, Định vị)
class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {
    public AmphibiousRobot(int id, String modelName) { super(id, modelName); }

    @Override
    public void performMainTask() { System.out.println(getModelName() + " performing main task"); }

    @Override
    public void fly() { System.out.println(getModelName() + " flying"); }

    @Override
    public void swim() { System.out.println(getModelName() + " swimming"); }

    @Override
    public void getCoordinates() { System.out.println(getModelName() + " getting coordinates"); }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Robot> robots = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int id = sc.nextInt();
            String name = sc.next();

            if (type.equals("DR")) robots.add(new DroneRobot(id, name));
            else if (type.equals("FR")) robots.add(new FishRobot(id, name));
            else if (type.equals("AR")) robots.add(new AmphibiousRobot(id, name));
        }

        // Duyệt danh sách và kiểm tra kỹ năng
        for (Robot r : robots) {
            r.performMainTask();

            // Downcasting an toàn bằng instanceof
            if (r instanceof Flyable) {
                ((Flyable) r).fly();
            }
            if (r instanceof Swimmable) {
                ((Swimmable) r).swim();
            }
            if (r instanceof GPS) {
                ((GPS) r).getCoordinates();
            }
            System.out.println(); // In dòng trống giữa các robot
        }
    }
}