import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class RomanCalculatorTest {

    private final String WRONG_INPUT_MESSAGE = "Wrong input";
    private final String WRONG_RESULT_MESSAGE = "Wrong number";

    @Test
    void emptyInput() {
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate(""));
    }

    @Test
    void nullInput() {
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate(null));
    }

    @Test
    void justWhiteSpaceInput() {
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate(" "));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("   "));
    }

    @Test
    void invalidOperator() {
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("I.I"));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("IaI"));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("I1I"));
    }

    @Test
    void missingOperator() {
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("II"));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("XIV"));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("V"));
    }

    @Test
    void multipleOperators() {
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("I++I"));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("X-/IV"));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("V*/V"));
    }

    @Test
    void invalidCharacterInOperand() {
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("a+I"));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("I- "));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("II*1"));
    }

    @Test
    void invalidRomanNumberInOperand() {
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("MMMM+I"));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("VV-1"));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("IL*1"));
    }

    @Test
    void missingOperand() {
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("I-"));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("*II"));
        assertEquals(WRONG_INPUT_MESSAGE, RomanCalculator.evaluate("/"));
    }

    @Test
    void plus() {
        assertEquals("II", RomanCalculator.evaluate("I+I"));
        assertEquals("L", RomanCalculator.evaluate("XL+X"));
    }

    @Test
    void plusRomanOverflow() {
        assertEquals(WRONG_RESULT_MESSAGE, RomanCalculator.evaluate("MM+MM"));
        assertEquals(WRONG_RESULT_MESSAGE, RomanCalculator.evaluate("I+MMMCMXCIX"));
    }

    @Test
    void spacesBeforeInput() {
        assertEquals("XX", RomanCalculator.evaluate(" X+X"));
        assertEquals("XX", RomanCalculator.evaluate("    X+X"));
    }

    @Test
    void spacesAfterInput() {
        assertEquals("II", RomanCalculator.evaluate("I+I "));
        assertEquals("II", RomanCalculator.evaluate("I+I   "));
    }

    @Test
    void spacesInsideInput() {
        assertEquals("MMX", RomanCalculator.evaluate("MM +X"));
        assertEquals("MMX", RomanCalculator.evaluate("MM+ X"));
        assertEquals("MMX", RomanCalculator.evaluate("MM + X"));
        assertEquals("MMX", RomanCalculator.evaluate("MM   +    X"));
    }

    @Test
    void spaces() {
        assertEquals("MMXX", RomanCalculator.evaluate(" M X + M X "));
        assertEquals("MMXX", RomanCalculator.evaluate("  M    X   +    M  X    "));
    }

    @Test
    void minus() {
        assertEquals("II", RomanCalculator.evaluate("IV-II"));
        assertEquals("L", RomanCalculator.evaluate("CXXX-LXXX"));
    }

    @Test
    void minusNegativeResult() {
        assertEquals(WRONG_RESULT_MESSAGE, RomanCalculator.evaluate("I-II"));
        assertEquals(WRONG_RESULT_MESSAGE, RomanCalculator.evaluate("MMMCMXCVIII-MMMCMXCIX"));
    }

    @Test
    void minusZeroResult() {
        assertEquals(WRONG_RESULT_MESSAGE, RomanCalculator.evaluate("I-I"));
        assertEquals(WRONG_RESULT_MESSAGE, RomanCalculator.evaluate("MMMCMXCIX-MMMCMXCIX"));
    }

    @Test
    void division() {
        assertEquals("I", RomanCalculator.evaluate("I/I"));
        assertEquals("II", RomanCalculator.evaluate("II/I"));
        assertEquals("III", RomanCalculator.evaluate("CL/L"));
    }

    @Test
    void divisionFractionalResult() {
        assertEquals(WRONG_RESULT_MESSAGE, RomanCalculator.evaluate("I/II"));
        assertEquals(WRONG_RESULT_MESSAGE, RomanCalculator.evaluate("MMMCMXCIX/CLII"));
    }

    @Test
    void multiplication() {
        assertEquals("I", RomanCalculator.evaluate("I*I"));
        assertEquals("CXLIV", RomanCalculator.evaluate("XII*XII"));
    }

    @Test
    void multiplicationRomanOverflow() {
        assertEquals(WRONG_RESULT_MESSAGE, RomanCalculator.evaluate("X*M"));
        assertEquals(WRONG_RESULT_MESSAGE, RomanCalculator.evaluate("D*VIII"));
    }

}
