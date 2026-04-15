// Thư viện cũ (không thể sửa đổi)
class LegacySorter {
    public int[] quickSort(int[] arr) {
        // Thực hiện thuật toán QuickSort (Minh họa)
        java.util.Arrays.sort(arr);
        System.out.println("Đã sắp xếp bằng LegacySorter (QuickSort).");
        return arr;
    }
}