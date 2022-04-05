import org.junit.jupiter.api.Test;

public class RomanCalculatorTest {

    @Test
    void allTests() {
        assert(RomanCalculator.evaluate("I+I").equals("II"));
        assert(RomanCalculator.evaluate("I + I").equals("II"));
        assert(RomanCalculator.evaluate("   I+I   ").equals("II"));
        assert(RomanCalculator.evaluate("II+I").equals("III"));
        assert(RomanCalculator.evaluate("C/L").equals("II"));
    }

}
