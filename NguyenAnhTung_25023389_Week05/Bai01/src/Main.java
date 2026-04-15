public class Main {

    public static void main(String[] args) {
        int iterations = 100000;

        // Thử nghiệm với String
        long startTime1 = System.currentTimeMillis();
        useString(iterations);
        long endTime1 = System.currentTimeMillis();
        System.out.println("Thời gian chạy với String: " + (endTime1 - startTime1) + " ms");

        // Thử nghiệm với StringBuffer
        long startTime2 = System.currentTimeMillis();
        useStringBuffer(iterations);
        long endTime2 = System.currentTimeMillis();
        System.out.println("Thời gian chạy với StringBuffer: " + (endTime2 - startTime2) + " ms");

        // Phân tích nội dung
        String text = "Java is powerful. Do you like Java? Yes, Java is great!";
        contentAnalysis(text);
    }

    // Hàm 1: Sử dụng String (Nối chuỗi bằng toán tử +)
    public static void useString(int count) {
        String s = "";
        for (int i = 0; i < count; i++) {
            s += "Hello";
        }
    }

    // Hàm 2: Sử dụng StringBuffer (Nối chuỗi bằng append)
    public static void useStringBuffer(int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append("Hello");
        }
        String result = sb.toString();
    }

    // Hàm 3: Phân tích nội dung văn bản
    public static void contentAnalysis(String text) {
        System.out.println("\n--- Phân tích nội dung ---");

        // 1. Đếm số lượng câu (dựa vào . ! ?)
        // Sử dụng regex để tách chuỗi dựa trên các dấu kết thúc câu
        String[] sentences = text.split("[.!?]");
        int sentenceCount = (text.trim().isEmpty()) ? 0 : sentences.length;
        System.out.println("Số lượng câu: " + sentenceCount);

        // 2. Tìm và thay thế "Java" thành "Python"
        // StringBuffer cung cấp tính năng an toàn trong môi trường đa luồng
        // Tuy nhiên, để replace nhanh, ta có thể dùng phương thức replace của String
        // hoặc dùng StringBuffer/StringBuilder để thao tác thủ công.
        String replacedText = text.replace("Java", "Python");
        System.out.println("Văn bản sau khi thay thế: " + replacedText);
    }
}