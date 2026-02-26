package Q4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calc = new Calculator();

    @Test
    void divide_positiveNumbers() {
        assertEquals(2.0, calc.divide(6, 3));
    }

    @Test
    void divide_negativeNumbers() {
        assertEquals(-3.0, calc.divide(12, -4));
    }

    @Test 
    void divide_byZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(1, 0));
    }
}
