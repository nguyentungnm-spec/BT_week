public class Main {
    public static void main(String[] args) {
        // 1. Tạo Pair<String, Integer>
        Pair<String, Integer> agePair = new Pair<>("Tuổi", 20);
        System.out.println(agePair);

        // 2. Tạo Pair<String, String>
        Pair<String, String> idPair = new Pair<>("Mã SV", "SV001");
        System.out.println(idPair);

        // 3. Tạo Pair<Integer, Double>
        Pair<Integer, Double> coordPair = new Pair<>(105, 21.5);
        System.out.println(coordPair);

        //  THỬ NGHIỆM LỖI 
        // bỏ comment dòng dưới đây, IDE sẽ báo đỏ ngay lập tức:
        // agePair.setValue("Hai mươi");
        // Lỗi: "Double cannot be converted to Integer" hoặc tương tự.
    }
}