import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorMethodsTest {

    @Test
    void roundDigit1() {
        double digit = 183.23824;
        assertEquals(183.24, CalculatorMethods.roundDigit(digit, 2));
    }
    @Test
    void roundDigit2() {
        double digit = 94.2382423421;
        assertEquals(94.238, CalculatorMethods.roundDigit(digit, 3));
    }
    @Test
    void roundDigit3() {
        double digit = 1245.942784612;
        assertEquals(1245.9428, CalculatorMethods.roundDigit(digit, 4));
    }

    @Test
    void calculateCurrency1() {
        Currency item = new Currency("PHP", 57.24);
        assertEquals(1545.48, CalculatorMethods.calculateCurrency(27, item));
    }
    @Test
    void calculateCurrency2() {
        Currency item = new Currency("INR", 81.384);
        assertEquals(11230.99, CalculatorMethods.calculateCurrency(138, item));
    }
    @Test
    void calculateCurrency3() {
        Currency item = new Currency("PLN", 4.7508);
        assertEquals(4860.07, CalculatorMethods.calculateCurrency(1023, item));
    }
}