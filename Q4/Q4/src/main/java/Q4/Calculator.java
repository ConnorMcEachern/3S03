package Q4;

public class Calculator {
    public double divide(double dividend, double divisor) throws IllegalArgumentException {
        if (divisor == 0) throw new IllegalArgumentException("Divisor cannot be zero");
        return dividend/divisor;
    }
}
