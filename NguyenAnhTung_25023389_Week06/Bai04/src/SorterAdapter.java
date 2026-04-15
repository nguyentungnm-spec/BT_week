// Adapter: Kết nối Sorter và LegacySorter
class SorterAdapter implements Sorter {
    private LegacySorter legacySorter;

    public SorterAdapter(LegacySorter legacySorter) {
        this.legacySorter = legacySorter;
    }

    @Override
    public int[] sort(int[] arr) {
        // Chuyển đổi lời gọi hàm từ sort() sang quickSort()
        return legacySorter.quickSort(arr);
    }
}