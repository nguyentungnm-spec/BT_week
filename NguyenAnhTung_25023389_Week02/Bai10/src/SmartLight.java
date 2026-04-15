class SmartLight {

    // Fields (private)
    private String id;
    private String name;
    private int brightness;

    // Constructor 1: đầy đủ tham số
    public SmartLight(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }

    // Constructor 2: 2 tham số, gọi constructor 1 bằng this(...)
    public SmartLight(String id, String name) {
        this(id, name, 50); // brightness mặc định = 50
    }

    // Getter để in thông tin
    public String getName() {
        return this.name;
    }

    public int getBrightness() {
        return this.brightness;
    }

    // Method 1: setBrightness(int)
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    // Method 2 (Overloading): setBrightness(String preset)
    public void setBrightness(String preset) {
        if (preset.equals("MAX")) {
            this.setBrightness(100);
        } else if (preset.equals("MIN")) {
            this.setBrightness(10);
        } else if (preset.equals("ECO")) {
            this.setBrightness(30);
        }
    }

    // Kết nối tới hub
    public void connectToHub(CentralHub hub) {
        hub.registerDevice(this); // truyền chính object hiện tại
    }
}