class AdvancedMath extends MathUtils {

    @Override
    public int sum(int a, int b) {
        return a + b + 10;
    }

    // Overload
    public double sum(double a, double b) {
        return a + b;
    }
}
