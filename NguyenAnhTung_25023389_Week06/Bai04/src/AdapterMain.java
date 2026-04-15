// Lớp chạy chương trình
public class AdapterMain {
    public static void main(String[] args) {
        int[] data = {5, 3, 8, 1, 2};

        // Sử dụng Adapter để dùng thư viện cũ thông qua Interface mới
        LegacySorter legacy = new LegacySorter();
        Sorter sorter = new SorterAdapter(legacy);

        int[] result = sorter.sort(data);

        System.out.print("Kết quả: ");
        for (int i : result) System.out.print(i + " ");
    }
}