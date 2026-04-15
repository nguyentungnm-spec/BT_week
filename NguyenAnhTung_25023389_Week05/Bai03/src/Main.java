import java.util.*;
public class Main {
    public static void main(String[] args) {
        String text = "Java is a high-level, class-based, object-oriented programming language. " +
                "Java is designed to have as few implementation dependencies as possible. " +
                "Java is fast, secure, and reliable!";

        // 1. Chuẩn hóa và tách từ
        // Loại bỏ tất cả ký tự không phải chữ cái và số (giữ lại khoảng trắng)
        String cleanedText = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = cleanedText.split("\\s+"); // Tách dựa trên 1 hoặc nhiều khoảng trắng

        // 2. Đếm số lần xuất hiện bằng HashMap
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            // Cách hiện đại: wordMap.merge(word, 1, Integer::sum);
            // Cách truyền thống theo yêu cầu đề bài:
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, wordMap.get(word) + 1);
            }
        }

        // 3. Tìm từ xuất hiện nhiều nhất
        String mostFrequentWord = "";
        int maxCount = 0;
        List<String> uniqueWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            // Kiểm tra tần suất lớn nhất
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }

            // Tìm các từ duy nhất (xuất hiện đúng 1 lần)
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }

        // 4. In kết quả
        System.out.println(" Thống kê từ vựng ");
        System.out.println("Tổng số từ khác nhau: " + wordMap.size());
        System.out.println("Từ xuất hiện nhiều nhất: '" + mostFrequentWord + "' (" + maxCount + " lần)");
        System.out.println("Các từ chỉ xuất hiện 1 lần: " + uniqueWords);
    }
}