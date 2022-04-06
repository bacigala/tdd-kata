import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class ArabicCalculatorTest {

    void simpleTest(int operand1, int operand2, char operator, Integer expected) {
        Integer result = ArabicCalculator.evaluate(operand1, operand2, operator);
        String message = operand1 + " " + operator + " " + operand2 + " = " + expected + " but got " + result;
        assertEquals(message, expected, result);
    }

    @Test
    void invalidOperator() {
        simpleTest(0,0,' ', null);
        simpleTest(1,1,'a', null);
        simpleTest(1,2,'!', null);
        simpleTest(1,1,'1', null);
        simpleTest(1,1,'=', null);
    }

    @Test
    void plus() {
        simpleTest(0,0,'+', 0);
        simpleTest(0,1,'+', 1);
        simpleTest(1,0,'+', 1);
        simpleTest(1,1,'+', 2);
        simpleTest(100,100,'+', 200);
        simpleTest(1,99,'+', 100);
        simpleTest(2,98,'+', 100);
    }

    @Test
    void negativeOperandPlus() {
        simpleTest(0,-1,'+', -1);
        simpleTest(-1,0,'+', -1);
        simpleTest(-1,-1,'+', -2);
        simpleTest(-100,1,'+', -99);
        simpleTest(-100,100,'+', 0);
        simpleTest(-99,100,'+', 1);
    }

    @Test
    void negativeZeroPlus() {
        simpleTest(0,-0,'+', 0);
        simpleTest(-0,0,'+', 0);
        simpleTest(-0,-0,'+', 0);
        simpleTest(1,-0,'+', 1);
        simpleTest(-0,1,'+', 1);
        simpleTest(-0,-1,'+', -1);
    }

    @Test
    void overflowPlus() {
        simpleTest(0, Integer.MAX_VALUE, '+', Integer.MAX_VALUE);
        simpleTest(1, Integer.MAX_VALUE, '+', Integer.MIN_VALUE);
        simpleTest(Integer.MAX_VALUE, -Integer.MAX_VALUE, '+', 0);
    }

    @Test
    void minus() {
        simpleTest(0,0,'-', 0);
        simpleTest(1,0,'-', 1);
        simpleTest(0,1,'-', -1);
        simpleTest(1,1,'-', 0);
        simpleTest(100,1,'-', 99);
    }

    @Test
    void negativeOperandMinus() {
        simpleTest(0,-1,'-', 1);
        simpleTest(1,-1,'-', 2);
        simpleTest(-1,-1,'-', 0);
        simpleTest(-2,-1,'-', -1);
        simpleTest(99,-1,'-', 100);
    }

    @Test
    void negativeZeroMinus() {
        simpleTest(0,-0,'-', 0);
        simpleTest(-0,0,'-', 0);
        simpleTest(-0,-0,'-', 0);
        simpleTest(1,-0,'-', 1);
        simpleTest(-0,1,'-', -1);
        simpleTest(-0,-1,'-', 1);
    }

    @Test
    void overflowMinus() {
        simpleTest(0, Integer.MAX_VALUE, '-', -Integer.MAX_VALUE);
        simpleTest(-1, Integer.MAX_VALUE, '-', Integer.MIN_VALUE);
        simpleTest(Integer.MAX_VALUE, Integer.MAX_VALUE, '-', 0);
    }

    @Test
    void multiplication() {
        simpleTest(0,0,'*', 0);
        simpleTest(1,0,'*', 0);
        simpleTest(0,1,'*', 0);
        simpleTest(1,1,'*', 1);
        simpleTest(2,60,'*', 120);
    }

    @Test
    void negativeOperandMultiplication() {
        simpleTest(0,-1,'*', 0);
        simpleTest(1,-1,'*', -1);
        simpleTest(-1,-1,'*', 1);
        simpleTest(-2,-1,'*', 2);
        simpleTest(99,-1,'*', -99);
    }

    @Test
    void negativeZeroMultiplication() {
        simpleTest(0,-0,'*', 0);
        simpleTest(-0,0,'*', 0);
        simpleTest(-0,-0,'*', 0);
        simpleTest(1,-0,'*', 0);
        simpleTest(-0,1,'*', 0);
        simpleTest(-0,-1,'*', 0);
    }

    @Test
    void division() {
        simpleTest(1,1,'/', 1);
        simpleTest(100,50,'/', 2);
        simpleTest(1000,50,'/', 20);
    }

    @Test
    void negativeOperandDivision() {
        simpleTest(1,-1,'/', -1);
        simpleTest(-1,1,'/', -1);
        simpleTest(-1,-1,'/', 1);
        simpleTest(-2,-1,'/', 2);
        simpleTest(99,-1,'/', -99);
    }

    @Test
    void negativeZeroDivision() {
        simpleTest(-0,1,'/', 0);
        simpleTest(-0,-1000,'/', 0);
        simpleTest(-0,1000,'/', 0);
    }

    @Test
    void zeroDivision() {
        simpleTest(1,0,'/', null);
        simpleTest(-1,0,'/', null);
        simpleTest(0,0,'/', null);
        simpleTest(0,-0,'/', null);
        simpleTest(-0,0,'/', null);
        simpleTest(-0,-0,'/', null);
    }

    @Test
    void fractalResultDivision() {
        simpleTest(1,2,'/', null);
        simpleTest(1000,3,'/', null);
        simpleTest(-1,2,'/', null);
        simpleTest(-1,-2,'/', null);
    }

}
