import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> wordMap;

    public WordCounter() {
        this.wordMap = new HashMap<>();
    }

    public void analyze(String text) {
        // B1: Chuẩn hóa chuỗi (chữ thường, xóa dấu câu cơ bản)
        // Regex [^a-zA-Z ] dùng để xóa các ký tự không phải chữ cái và khoảng trắng
        String cleanText = text.toLowerCase().replaceAll("[.,!?:;]", "");

        // B2: Tách chuỗi thành mảng các từ bằng khoảng trắng
        String[] words = cleanText.split("\\s+");

        // B3: Duyệt mảng và đưa vào HashMap
        for (String word : words) {
            if (word.isEmpty()) continue;

            if (wordMap.containsKey(word)) {
                // Nếu đã có: tăng số lượng lên 1
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                // Nếu chưa có: thêm mới với giá trị là 1
                wordMap.put(word, 1);
            }
        }
    }

    public void displayResult() {
        System.out.println("--- Thống kê tần suất từ ---");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void findMostFrequent() {
        String mostFrequentWord = null;
        int maxCount = -1;

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }

        if (mostFrequentWord != null) {
            System.out.println("\n=> Từ xuất hiện nhiều nhất: '" + mostFrequentWord + "' (" + maxCount + " lần)");
        }
    }

    public static void main(String[] args) {
        WordCounter counter = new WordCounter();
        String input = "Hello world. This is a java program. Hello java, hello world.";

        counter.analyze(input);
        counter.displayResult();
        counter.findMostFrequent();
    }
}