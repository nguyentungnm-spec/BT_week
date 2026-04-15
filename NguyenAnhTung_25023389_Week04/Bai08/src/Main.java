import java.util.*;

// 1. Abstract Class cho tất cả thiết bị
abstract class Device {
    protected String id;
    protected String name;
    protected boolean isOn;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = true; // Giả sử mặc định đang bật để test hàm tắt
    }

    public abstract void turnOff();
    public String getName() { return name; }
}

// 2. Interface cho các tính năng đặc thù
interface IWifi {
    void setupWifi();
}

interface IAdjustable {
    void adjust(int level);
}

// 3. Các lớp thiết bị cụ thể
class SmartLight extends Device implements IAdjustable {
    public SmartLight(String id, String name) { super(id, name); }
    @Override
    public void turnOff() { System.out.println(name + " turned off"); }
    @Override
    public void adjust(int level) { System.out.println(name + " brightness set to " + level); }
}

class AirConditioner extends Device implements IWifi {
    public AirConditioner(String id, String name) { super(id, name); }
    @Override
    public void turnOff() { System.out.println(name + " turned off"); }
    @Override
    public void setupWifi() { System.out.println(name + " connected to wifi"); }
}

class SmartSpeaker extends Device implements IWifi, IAdjustable {
    public SmartSpeaker(String id, String name) { super(id, name); }
    @Override
    public void turnOff() { System.out.println(name + " turned off"); }
    @Override
    public void setupWifi() { System.out.println(name + " connected to wifi"); }
    @Override
    public void adjust(int level) { System.out.println(name + " volume set to " + level); }
}

class Curtain extends Device {
    public Curtain(String id, String name) { super(id, name); }
    @Override
    public void turnOff() { System.out.println(name + " turned off"); }
}

// 4. Lớp Hub điều khiển trung tâm
class SmartHub {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device d) { devices.add(d); }

    public void turnOffAll() {
        System.out.println("Turn Off All Devices:");
        for (Device d : devices) {
            d.turnOff();
        }
    }

    public void setupWifiAll() {
        System.out.println("\nSetup Wifi:");
        for (Device d : devices) {
            // Kiểm tra xem thiết bị có "cài đặt" tính năng Wifi hay không
            if (d instanceof IWifi) {
                ((IWifi) d).setupWifi();
            }
        }
    }
}

// 5. Main class để chạy chương trình
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmartHub hub = new SmartHub();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];

            switch (type) {
                case "L": hub.addDevice(new SmartLight(id, name)); break;
                case "AC": hub.addDevice(new AirConditioner(id, name)); break;
                case "S": hub.addDevice(new SmartSpeaker(id, name)); break;
                case "C": hub.addDevice(new Curtain(id, name)); break;
            }
        }

        hub.turnOffAll();
        hub.setupWifiAll();
    }
}