public class Main {
    public static void main(String[] args) {

        CentralHub hub = new CentralHub();

        // Tạo đèn bằng constructor đầy đủ
        SmartLight l1 = new SmartLight("L01", "Đèn phòng khách", 80);

        // Tạo đèn bằng constructor 2 tham số
        SmartLight l2 = new SmartLight("L02", "Đèn ngủ");

        // Set preset ECO cho l2
        l2.setBrightness("ECO");

        // Kết nối vào hub
        l1.connectToHub(hub);
        l2.connectToHub(hub);

        // In độ sáng hiện tại
        System.out.println(l1.getName() + " - Brightness: " + l1.getBrightness());
        System.out.println(l2.getName() + " - Brightness: " + l2.getBrightness());
    }
}