import java.util.*;
class PrimeCounter extends Thread {
    private int[] array;
    private int index;
    private int primeCount = 0;

    public PrimeCounter(int[] array, int index) {
        this.array = array;
        this.index = index;
    }

    // Hàm kiểm tra số nguyên tố
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public void run() {
        for (int num : array) {
            if (isPrime(num)) {
                primeCount++;
            }
        }
    }

    public int getPrimeCount() {
        return primeCount;
    }

    public int getIndex() {
        return index;
    }
}