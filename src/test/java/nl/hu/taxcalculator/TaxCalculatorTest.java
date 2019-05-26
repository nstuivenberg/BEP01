package nl.hu.taxcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TaxCalculatorTest {

    private TaxCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new TaxCalculator();
    }

    @Test
    public void zeroInome() {
        calculator = new TaxCalculator();
        assertEquals(calculator.calculateTax(0), 0);
    }

    @Test
    public void shouldPayMaxAmountFirstTier() {
        assertEquals(7361, calculator.calculateTax(20142));
    }

    @Test
    public void shouldPayMaxAmountSecondTier() {
        assertEquals(13019, calculator.calculateTax(33994));
    }
    @Test
    public void shouldPayMaxAmountThirdTier() {
        assertEquals(27118, calculator.calculateTax(68507));
    }

    @Test
    public void shouldPayALotOfMoneyWhen100k() {
        assertEquals(39982, calculator.calculateTax(100000));
    }
}
