import java.util.concurrent.Callable;

// Lớp Callable để tính tổng một đoạn mảng
class SumTask implements Callable<Integer> {
    private int[] arr;
    private int start;
    private int end;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        System.out.println(Thread.currentThread().getName() + " tính từ " + start + " đến " + (end-1) + " = " + sum);
        return sum;
    }
}